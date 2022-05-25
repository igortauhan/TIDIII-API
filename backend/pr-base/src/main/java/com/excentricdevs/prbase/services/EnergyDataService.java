package com.excentricdevs.prbase.services;

import com.excentricdevs.prbase.models.dto.EnergyDataDto;
import com.excentricdevs.prbase.models.EnergyData;
import com.excentricdevs.prbase.repositories.EnergyDataRepository;
import com.excentricdevs.prbase.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnergyDataService {

    @Autowired
    private EnergyDataRepository energyDataRepository;

    public Page<EnergyDataDto> findAll(Pageable pageable) {
        Page<EnergyData> energyDataList = energyDataRepository.findAll(pageable);
        return energyDataList.map(EnergyDataDto::new);
    }

    public EnergyDataDto findById(String id) {
        Optional<EnergyData> energyData = energyDataRepository.findById(id);
        return new EnergyDataDto(energyData.orElseThrow(
                () -> new ObjectNotFoundException("Registro de energia não encontrado. Id:" + id)
        ));
    }

    public EnergyDataDto insert(EnergyDataDto energyDataDto) {
        energyDataDto.setId(null);
        energyDataDto.setRegistrationDate(new Date());
        EnergyData energyData = energyDataRepository.insert(fromDto(energyDataDto));
        return new EnergyDataDto(energyData);
    }

    public EnergyDataDto update(EnergyDataDto newEnergyDataDto, String id) {
        EnergyDataDto energyDataDto = findById(id);
        energyDataDto.setId(id);
        energyDataDto.setValue(newEnergyDataDto.getValue());
        energyDataDto.setRegistrationDate(new Date());
        EnergyData energyData = energyDataRepository.save(fromDto(energyDataDto));
        return new EnergyDataDto(energyData);
    }

    public void delete(String id) {
        energyDataRepository.deleteById(id);
    }

    private EnergyData fromDto(EnergyDataDto energyDataDto) {
        return new EnergyData(energyDataDto.getId(), energyDataDto.getValue(), energyDataDto.getRegistrationDate());
    }
}
