package com.excentricdevs.prbase.repositories;

import com.excentricdevs.prbase.models.EnergyData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnergyDataRepository extends MongoRepository<EnergyData, String> {
}
