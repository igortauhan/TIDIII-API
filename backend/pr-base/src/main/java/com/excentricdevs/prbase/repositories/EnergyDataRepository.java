package com.excentricdevs.prbase.repositories;

import com.excentricdevs.prbase.models.EnergyData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EnergyDataRepository extends MongoRepository<EnergyData, String> {

    List<EnergyData> findByRegistrationDateBetween(Date initDate, Date finalDate);
}
