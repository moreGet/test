package com.example.dto;

import com.example.domain.code.ModusignDocumentHistoryStatus;
import com.example.domain.code.ModusignDocumentStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

public class GetContractInformationDetailsDto {

    public static class Request {

    }

    @Getter
    public static class Response {

        /**
         * 이력 조회 기준 부모 id값
         */
        private String id;

        /**
         * 이력 조회 기준 부모 status값
         */
        private ModusignDocumentStatus status;

        private List<ParticipantData> participants;

        public Response(String id, ModusignDocumentStatus status, List<ParticipantData> participants) {
            this.id = id;
            this.status = status;
            this.participants = participants;
        }

        public String getStatus() {
            return status.getDescription();
        }
    }

    @Getter
    public static class ParticipantData {
        private String message;
        private String name;
        private String contact;
        private LocalDateTime timestamp;
        private ModusignDocumentHistoryStatus action;

        public ParticipantData(String message, String name, String contact, LocalDateTime timestamp, ModusignDocumentHistoryStatus action) {
            this.message = message;
            this.name = name;
            this.contact = contact;
            this.timestamp = timestamp;
            this.action = action;
        }

        public String getAction() {
            return action.getDescription();
        }
    }
}
