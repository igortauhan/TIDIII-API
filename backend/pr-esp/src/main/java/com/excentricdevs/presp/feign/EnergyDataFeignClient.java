package com.excentricdevs.presp.feign;

import com.excentricdevs.presp.models.EnergyData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pr-base", path = "/esp")
@Component
public interface EnergyDataFeignClient {

    @PostMapping
    ResponseEntity<EnergyData> insert(@RequestBody EnergyData energyData);
}
