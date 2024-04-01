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
public enum ModusignDocumentHistoryStatus {
    START_SIGNING_REQUEST("요청자가 서명 요청 시작"),
    SIGNING_REQUEST("시스템의 서명 요청 전송"),
    FIRST_READING_DOCUMENT_IN_SIGNING_TURN("참여자의 첫 문서 조회"),
    READING_DOCUMENT_IN_SIGNING_TURN("참여자의 문서 조회"),
    VERIFICATION_FAILURE("추가 인증 실패"),
    VERIFICATION_EXCEEDED("추가 인증 5회 실패"),
    VERIFICATION_COMPLETED("인증 성공"),
    SIGNING_COMPLETED("서명 입력"),
    SIGNING_COMPLETED_ALL("모든 서명 입력 완료"),
    REJECT_SIGNING("서명 거절"),
    CANCEL_SIGNING("서명 취소"),
    CANCEL_SIGNING_REQUEST("서명 요청 취소"),
    REMIND_SIGNING("서명 알림 재전송"),
    CHANGE_SIGNING_EXPIRY_DATE("서명 유효 기간 수정");

    private String description;
}
