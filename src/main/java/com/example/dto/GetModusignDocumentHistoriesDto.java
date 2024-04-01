package com.example.dto;

import com.example.domain.code.HistoryDataType;
import com.example.domain.code.ModusignDocumentHistoryStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class GetModusignDocumentHistoriesDto {

    public static class Request {

    }


    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class Response {
        private List<HistoryData> histories;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class HistoryData {
        private String message;
        private Timestamp timestamp;
        private ModusignDocumentHistoryStatus action;

        private GeneratorData generator;
        private TargetData target;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeneratorData {
        private HistoryDataType type;
        private String name;
        private String contact;
    }

    @Getter
    @Setter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TargetData {
        private HistoryDataType type;
        private String name;
        private String contact;
    }
}
