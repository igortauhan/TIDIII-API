package com.excentricdevs.presp.services;

import com.excentricdevs.presp.feign.EnergyDataFeignClient;
import com.excentricdevs.presp.models.EnergyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspService {

    @Autowired
    private EnergyDataFeignClient energyDataFeignClient;

    public EnergyData insert(EnergyData energyData) {
        energyData = energyDataFeignClient.insert(energyData).getBody();
        return energyData;
    }
}
