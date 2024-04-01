package com.example.domain.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LocationCode {

    ONE("ONE"),
    TWO("TWO");

    private String desc;
}
