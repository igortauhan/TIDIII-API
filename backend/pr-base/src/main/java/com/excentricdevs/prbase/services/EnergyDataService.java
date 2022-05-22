package com.excentricdevs.prbase.services;

import com.excentricdevs.prbase.models.EnergyData;
import com.excentricdevs.prbase.repositories.EnergyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EnergyDataService {

    @Autowired
    private EnergyDataRepository energyDataRepository;

    public List<EnergyData> findAll() {
        return energyDataRepository.findAll();
    }

    public EnergyData findById(String id) {
        Optional<EnergyData> energyData = energyDataRepository.findById(id);
        return energyData.orElse(null);
    }

    public EnergyData insert(EnergyData energyData) {
        energyData.setId(null);
        energyData.setRegistrationDate(new Date());
        energyData = energyDataRepository.insert(energyData);
        return energyData;
    }

    public EnergyData update(EnergyData newEnergyData, String id) {
        EnergyData energyData = findById(id);
        energyData.setValue(newEnergyData.getValue());
        energyData.setRegistrationDate(new Date());

        energyData = energyDataRepository.save(energyData);
        return energyData;
    }
}
