package com.example;

import com.example.domain.*;
import com.example.domain.code.HistoryDataType;
import com.example.domain.code.LocationCode;
import com.example.domain.code.ModusignDocumentStatus;
import com.example.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/location")
@RequiredArgsConstructor
@RestController
public class TestApi {

    private final PersonRepository personRepository;
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;

    private final ObjectMapper om = new ObjectMapper();

    @Transactional
    @PostMapping
    public ResponseEntity<String> createLocation() {
        Person person = new Person("personName");
        person = personRepository.save(person);

        User user0 = new User("user0");
        User user = new User("user1");
        user0.update(person);

        Location location = new Location("locName", List.of(user, user0));
        location.updateLocationCodes(List.of(EmbededCollection.builder()
                .locationCode1(LocationCode.TWO)
                .locationCode2(LocationCode.TWO)
                .locationCode3(LocationCode.TWO)
                .build()));
        locationRepository.save(location);

        User user2 = new User("user2");
        user2.update(person);

        Location location2 = new Location("locName", List.of(user2));
        locationRepository.save(location2);

        person.addUser(user);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("데이터가 존재하지 않습니다."));
        return ResponseEntity.ok(location);
    }

    /**
     * 아래 3가지 전부 관계 삭제가 가능 하지만 1, 2번 방법을 사용하는 것이 바람직 하다.
     * 1. location.changeUser(new ArrayList<>());
     * 2. location.changeUser(null);
     * 3. location.getUsers().clear();
     */
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("데이터가 존재하지 않습니다."));

//        location.changeUser(new ArrayList<>());
//        location.changeUser(null);
        location.getUsers().clear();
        return ResponseEntity.ok("삭제 성공");
    }

    @Transactional
    @DeleteMapping("/{id}/obj")
    public ResponseEntity<String> deleteLocationObj(@PathVariable Long id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("데이터가 존재하지 않습니다."));

        locationRepository.delete(location);
        return ResponseEntity.ok("삭제 성공");
    }

    @GetMapping("/history")
    public ResponseEntity<?> getHistory(@RequestParam Long option) throws JsonProcessingException {
        om.registerModule(new JavaTimeModule());
        DocJson docJson = new DocJson();

        String jsonDocuments = docJson.getDocuments();
        String jsonDocumentDetail = docJson.getDocumentDetail();

        if (option == 1L) {
            GetModusignDocumentsDto.Response documents =
                    om.readValue(jsonDocuments, GetModusignDocumentsDto.Response.class);

            List<GetContractInformationsDto.Response> contractInformations =
                    documents.getDocuments().stream().map(GetContractInformationsDto.Response::fromEntity).toList();

            return ResponseEntity.ok(contractInformations);
        } else {
            GetModusignDocumentHistoriesDto.Response documentHistories =
                    om.readValue(jsonDocumentDetail, GetModusignDocumentHistoriesDto.Response.class);

            /**
             * 화면 대로 작성
             */
            List<GetModusignDocumentHistoriesDto.HistoryData> histories = documentHistories.getHistories();

            // 오름 차순 정렬
            histories.sort(Comparator.comparing(GetModusignDocumentHistoriesDto.HistoryData::getTimestamp));
            Map<String, GetContractInformationDetailsDto.ParticipantData> collect = histories.stream()
                    .filter(h -> h.getGenerator().getType().equals(HistoryDataType.SYSTEM)
                            || h.getGenerator().getType().equals(HistoryDataType.PARTICIPANT))
                    .peek(h -> {
                        if (h.getGenerator().getType().equals(HistoryDataType.SYSTEM)) {
                            GetModusignDocumentHistoriesDto.GeneratorData generatorData = new GetModusignDocumentHistoriesDto.GeneratorData();
                            GetModusignDocumentHistoriesDto.TargetData targetData = h.getTarget();

                            generatorData.setType(targetData.getType());
                            generatorData.setName(targetData.getName());
                            generatorData.setContact(targetData.getContact());
                            
                            h.setGenerator(generatorData);
                        }
                    })
                    .collect(Collectors.toMap(
                            h -> h.getGenerator().getContact(),
                            h -> new GetContractInformationDetailsDto.ParticipantData(
                                    h.getMessage(), h.getGenerator().getName(), h.getGenerator().getContact(),
                                    h.getTimestamp(), h.getAction()),

                            // 중복 키 덮어씌우기
                            (existing, replacement) -> replacement
                    ));

            ArrayList<GetContractInformationDetailsDto.ParticipantData> participantData = new ArrayList<>(collect.values());
            GetContractInformationDetailsDto.Response contractInformationDetails =
                    new GetContractInformationDetailsDto.Response("모두싸인부모ID", ModusignDocumentStatus.ON_GOING, participantData);
            return ResponseEntity.ok(contractInformationDetails);
        }
    }
}
