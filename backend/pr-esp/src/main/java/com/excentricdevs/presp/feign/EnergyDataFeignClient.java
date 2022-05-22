package com.excentricdevs.presp.feign;

import com.excentricdevs.presp.dto.EnergyDataDto;
import com.excentricdevs.presp.models.EnergyData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pr-base", path = "/energy")
@Component
public interface EnergyDataFeignClient {

    @PostMapping
    public ResponseEntity<EnergyDataDto> insert(@RequestBody EnergyDataDto energyData);
}
