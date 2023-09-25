package com.example.controller;
//완성하기
import com.example.domain.entity.EnterpriseInfo;
import com.example.service.EnterpriseInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "기업 투자 정보 컨트롤러")
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class EnterpriseInfoController {
    private final EnterpriseInfoService enterpriseInfoService;

    @GetMapping("/v1/enterpriseinfo/{enterId}")
    public EnterpriseInfo getEnterpriseInfo(
            @PathVariable(value = "enterId") long enterId
    ) {
        return enterpriseInfoService.getEnterpriseInfo(enterId);
    }

    @PostMapping("/v1/enterpriseinfo/{enterId}")
    public EnterpriseInfo createEnterpriseInfo(
            @PathVariable(value = "enterId") long enterId,
            @RequestBody EnterpriseInfoRequest enterpriseInfoRequest
    ) {
        return enterpriseInfoService.createEnterpriseInfo(enterId, enterpriseInfoRequest);
    }

    @PutMapping("/v1/enterpriseinfo/{enterId}")
    public EnterpriseInfo updateEnterpriseInfo(
            @PathVariable(value = "enterId") long enterId,
            @RequestBody EnterpriseInfoRequest enterpriseInfoRequest
    ) {
        return enterpriseInfoService.updateEnterpriseInfo(enterId, enterpriseInfoRequest);
    }

    @DeleteMapping("/v1/enterpriseinfo/{enterId}")
    public EnterpriseInfo deleteEnterpriseInfo(
            @PathVariable(value = "enterId") long enterId
    ) {
        return enterpriseInfoService.deleteEnterpriseInfo(enterId);
    }
}
