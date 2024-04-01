package com.example.domain.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum HistoryDataType {

    SYSTEM,
    REQUESTER,
    PARTICIPANT
}
