package com.excentricdevs.prbase.services;

import com.excentricdevs.prbase.models.EnergyData;
import com.excentricdevs.prbase.repositories.EnergyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnergyDataService {

    @Autowired
    private EnergyDataRepository energyDataRepository;

    public List<EnergyData> findAll() {
        return energyDataRepository.findAll();
    }
}
