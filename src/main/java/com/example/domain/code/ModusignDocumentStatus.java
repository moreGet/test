package com.example.domain.code;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * https://developers.modusign.co.kr/reference/documentcontroller_getdocuments
 * Search 문법 status eq 'COMPLETED'
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ModusignDocumentStatus {
    COMPLETED("완료됨"),
    ON_PROCESSING("관련 리소스 생성 중"),
    PROCESSING_FAILED("관련 리소스 생성 실패"),
    ON_GOING("서명 진행중"),
    ABORTED("서명이 취소되거나 거절됨");

    private String description;
}
