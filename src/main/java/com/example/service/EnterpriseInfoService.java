package com.example.service;

import com.example.domain.entity.EnterpriseInfo;
import com.example.domain.response.MovieResponse;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnterpriseInfoService {
    private static List<EnterpriseInfo> information = new ArrayList<>();

    @PostConstruct
    public void init() {

    }

    public List<EnterpriseInfoResponse> getEnterpriseInfo() {
        return information.stream().map(MovieResponse::of).toList();
    }

}
