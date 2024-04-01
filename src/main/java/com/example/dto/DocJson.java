package com.example.dto;

import lombok.Getter;

@Getter
public class DocJson {

    private String documents = "{\n" +
            "    \"count\": 2,\n" +
            "    \"documents\": [\n" +
            "      {\n" +
            "        \"id\": \"0fde8110-ef4b-11ee-8ca2-0f64e00d1ae8\",\n" +
            "        \"title\": \"site1번템플릿\",\n" +
            "        \"status\": \"ON_GOING\",\n" +
            "        \"requester\": {\n" +
            "          \"name\": \"한국기술마켓\",\n" +
            "          \"email\": \"jee-yk@kotechmarket.com\"\n" +
            "        },\n" +
            "        \"participants\": [\n" +
            "          {\n" +
            "            \"id\": \"10148530-ef4b-11ee-81b7-b9b2f97597c0\",\n" +
            "            \"name\": \"신성현2\",\n" +
            "            \"signingOrder\": 1,\n" +
            "            \"signingDue\": {\n" +
            "              \"valid\": true,\n" +
            "              \"datetime\": \"2024-04-14T10:40:17.292Z\"\n" +
            "            },\n" +
            "            \"signingMethod\": {\n" +
            "              \"type\": \"EMAIL\",\n" +
            "              \"value\": \"3965455@naver.com\"\n" +
            "            },\n" +
            "            \"locale\": \"ko\"\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": \"10145e20-ef4b-11ee-81b7-b9b2f97597c0\",\n" +
            "            \"name\": \"신성현1\",\n" +
            "            \"signingOrder\": 1,\n" +
            "            \"signingDue\": {\n" +
            "              \"valid\": true,\n" +
            "              \"datetime\": \"2024-04-14T10:40:17.292Z\"\n" +
            "            },\n" +
            "            \"signingMethod\": {\n" +
            "              \"type\": \"EMAIL\",\n" +
            "              \"value\": \"dkdlwmzhs@naver.com\"\n" +
            "            },\n" +
            "            \"locale\": \"ko\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"currentSigningOrder\": 1,\n" +
            "        \"signings\": [],\n" +
            "        \"accessibleByParticipant\": true,\n" +
            "        \"abort\": null,\n" +
            "        \"metadatas\": [\n" +
            "          {\n" +
            "            \"key\": \"siteId\",\n" +
            "            \"value\": \"1\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"labels\": [],\n" +
            "        \"updatedAt\": \"2024-03-31T10:40:17.000Z\",\n" +
            "        \"createdAt\": \"2024-03-31T10:40:17.000Z\",\n" +
            "        \"file\": {\n" +
            "          \"downloadUrl\": \"https://api.modusign.co.kr/documents/0fde8110-ef4b-11ee-8ca2-0f64e00d1ae8/file?signedUrlToken=documents%2F0fde8110-ef4b-11ee-8ca2-0f64e00d1ae8%2FpdfFile%2F01HTA1GYY7Z2XCEA16A56JET1G-latest.pdf%3FX-Amz-Algorithm%3DAWS4-HMAC-SHA256%26X-Amz-Credential%3DAKIA3EQMQCJY6OUIE6Q7%252F20240401%252Fap-northeast-2%252Fs3%252Faws4_request%26X-Amz-Date%3D20240401T004544Z%26X-Amz-Expires%3D600%26X-Amz-Signature%3D6090233649a84b508309c8778c421b43c05c9f59fd95f616e81c9371fb7d8137%26X-Amz-SignedHeaders%3Dhost\"\n" +
            "        },\n" +
            "        \"auditTrail\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }";

    private String documentDetail = "{\n" +
            "  \"histories\": [\n" +
            "    {\n" +
            "      \"message\": \"한국기술마켓(jee-yk@kotechmarket.com) 님이 서명 요청을 시작하였습니다.\",\n" +
            "      \"timestamp\": \"2024-03-31T10:40:17.000Z\",\n" +
            "      \"action\": \"START_SIGNING_REQUEST\",\n" +
            "      \"generator\": {\n" +
            "        \"type\": \"REQUESTER\",\n" +
            "        \"name\": \"한국기술마켓\",\n" +
            "        \"contact\": \"jee-yk@kotechmarket.com\",\n" +
            "        \"environment\": {\n" +
            "          \"userIp\": \"222.108.40.175\",\n" +
            "          \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"target\": null,\n" +
            "      \"details\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"신성현1(dkdlwmzhs@naver.com)님에게 서명할 문서를 전송하였습니다.\",\n" +
            "      \"timestamp\": \"2024-03-31T10:40:17.000Z\",\n" +
            "      \"action\": \"SIGNING_REQUEST\",\n" +
            "      \"generator\": {\n" +
            "        \"type\": \"SYSTEM\",\n" +
            "        \"name\": null,\n" +
            "        \"contact\": null,\n" +
            "        \"environment\": null\n" +
            "      },\n" +
            "      \"target\": {\n" +
            "        \"type\": \"PARTICIPANT\",\n" +
            "        \"name\": \"신성현1\",\n" +
            "        \"contact\": \"dkdlwmzhs@naver.com\"\n" +
            "      },\n" +
            "      \"details\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"신성현2(3965455@naver.com)님에게 서명할 문서를 전송하였습니다.\",\n" +
            "      \"timestamp\": \"2024-03-31T10:40:17.000Z\",\n" +
            "      \"action\": \"SIGNING_REQUEST\",\n" +
            "      \"generator\": {\n" +
            "        \"type\": \"SYSTEM\",\n" +
            "        \"name\": null,\n" +
            "        \"contact\": null,\n" +
            "        \"environment\": null\n" +
            "      },\n" +
            "      \"target\": {\n" +
            "        \"type\": \"PARTICIPANT\",\n" +
            "        \"name\": \"신성현2\",\n" +
            "        \"contact\": \"3965455@naver.com\"\n" +
            "      },\n" +
            "      \"details\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"신성현1(dkdlwmzhs@naver.com)님이 문서의 내용을 확인하였습니다.\",\n" +
            "      \"timestamp\": \"2024-04-01T00:41:32.000Z\",\n" +
            "      \"action\": \"FIRST_READING_DOCUMENT_IN_SIGNING_TURN\",\n" +
            "      \"generator\": {\n" +
            "        \"type\": \"PARTICIPANT\",\n" +
            "        \"name\": \"신성현1\",\n" +
            "        \"contact\": \"dkdlwmzhs@naver.com\",\n" +
            "        \"environment\": {\n" +
            "          \"userIp\": \"118.235.7.210\",\n" +
            "          \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"target\": null,\n" +
            "      \"details\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"신성현1(dkdlwmzhs@naver.com)님이 문서의 내용을 확인하였습니다.\",\n" +
            "      \"timestamp\": \"2024-04-01T01:03:02.000Z\",\n" +
            "      \"action\": \"READING_DOCUMENT_IN_SIGNING_TURN\",\n" +
            "      \"generator\": {\n" +
            "        \"type\": \"PARTICIPANT\",\n" +
            "        \"name\": \"신성현1\",\n" +
            "        \"contact\": \"dkdlwmzhs@naver.com\",\n" +
            "        \"environment\": {\n" +
            "          \"userIp\": \"118.235.7.210\",\n" +
            "          \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"target\": null,\n" +
            "      \"details\": null\n" +
            "    },\n" +
            "    {\n" +
            "      \"message\": \"신성현1(dkdlwmzhs@naver.com)님이 문서에 서명하였습니다.\",\n" +
            "      \"timestamp\": \"2024-04-01T01:03:28.000Z\",\n" +
            "      \"action\": \"SIGNING_COMPLETED\",\n" +
            "      \"generator\": {\n" +
            "        \"type\": \"PARTICIPANT\",\n" +
            "        \"name\": \"신성현1\",\n" +
            "        \"contact\": \"dkdlwmzhs@naver.com\",\n" +
            "        \"environment\": {\n" +
            "          \"userIp\": \"118.235.7.210\",\n" +
            "          \"userAgent\": \"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/123.0.0.0 Safari/537.36\"\n" +
            "        }\n" +
            "      },\n" +
            "      \"target\": null,\n" +
            "      \"details\": null\n" +
            "    }\n" +
            "  ]\n" +
            "}";
}
