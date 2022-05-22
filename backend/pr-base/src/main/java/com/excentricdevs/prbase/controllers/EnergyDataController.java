package com.excentricdevs.prbase.controllers;

import com.excentricdevs.prbase.models.EnergyData;
import com.excentricdevs.prbase.services.EnergyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/energy")
public class EnergyDataController {

    @Autowired
    private EnergyDataService energyDataService;

    @GetMapping
    public ResponseEntity<List<EnergyData>> findAll() {
        return ResponseEntity.ok(energyDataService.findAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnergyData> findById(@PathVariable String id) {
        return ResponseEntity.ok(energyDataService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnergyData> insert(@RequestBody EnergyData energyData) {
        energyData = energyDataService.insert(energyData);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(energyData.getId()).toUri();
        return ResponseEntity.created(uri).body(energyData);
    }
}
