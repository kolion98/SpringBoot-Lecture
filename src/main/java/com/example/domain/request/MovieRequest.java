package com.example.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MovieRequest {
    private Long id;
    private String name;
    private Integer productionYear;
}
