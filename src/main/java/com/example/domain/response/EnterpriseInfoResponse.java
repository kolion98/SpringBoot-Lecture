package com.example.domain.response;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
@Getter
@Builder
@RequiredArgsConstructor
public class EnterpriseInfoResponse {
    private final long id;
    private final String title;
    private final String contents;
    private final boolean isNew;
    private final String img;
    private final String pdfURL;
    private final String registerDate;
    private final String opinion;
    private final String eName;
    private final String fName;
    private final Integer checkNum;
    private final String aName;
}
