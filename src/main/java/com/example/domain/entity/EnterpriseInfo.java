package com.example.domain.entity;

import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EnterpriseInfo {
    private long id;
    private String title;
    private String contents;
    private boolean isNew;
    private String img;
    private String pdfURL;
    private String registerDate;
    private String opinion;
    private String eName;
    private String fName;
    private Integer checkNum;
    private String aName;
}