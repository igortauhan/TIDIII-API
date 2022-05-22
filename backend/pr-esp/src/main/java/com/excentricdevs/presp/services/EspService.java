package com.excentricdevs.presp.services;

import com.excentricdevs.presp.dto.EnergyDataDto;
import com.excentricdevs.presp.feign.EnergyDataFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspService {

    @Autowired
    private EnergyDataFeignClient energyDataFeignClient;

    public EnergyDataDto insert(EnergyDataDto energyDataDto) {
        energyDataDto = energyDataFeignClient.insert(energyDataDto).getBody();
        return energyDataDto;
    }
}
