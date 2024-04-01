package com.example.dto;

import com.example.domain.code.ModusignDocumentStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

public class GetModusignDocumentsDto {

    public static class Request {

    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {
        long count;
        List<DocumentData> documents;
    }

    /**
     * MODEL
     * return new PageImpl<>(dto, pageable, count);
     */
    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class DocumentData {

        String id;

        String title;

        ModusignDocumentStatus status;

        // 요청자
        RequesterData requester;

        // 참여자
        List<ParticipantData> participants;

        LocalDateTime updatedAt;

        LocalDateTime createdAt;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class RequesterData {

        String name;

        String email;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ParticipantData {

        String id;

        String name;

        SigningMethodData signingMethod;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class SigningMethodData {

        String type;

        String value;
    }
}
