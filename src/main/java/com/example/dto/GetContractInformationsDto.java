package com.example.dto;

import com.example.domain.code.ModusignDocumentStatus;
import lombok.Getter;

import java.time.LocalDateTime;

public class GetContractInformationsDto {

    public static class Request {

    }

    @Getter
    public static class Response {
        private String id;
        private String title;
        private ModusignDocumentStatus status;
        private LocalDateTime createAt;
        private LocalDateTime updateAt;

        public Response(String id, String title, ModusignDocumentStatus status, LocalDateTime createAt, LocalDateTime updateAt) {
            this.id = id;
            this.title = title;
            this.status = status;
            this.createAt = createAt;
            this.updateAt = updateAt;
        }

        public static Response fromEntity(GetModusignDocumentsDto.DocumentData documentData) {
            return new Response(documentData.getId(), documentData.getTitle(), documentData.getStatus(),
                    documentData.getCreatedAt(), documentData.getUpdatedAt());
        }

        public String getStatus() {
            return status.getDescription();
        }
    }
}
