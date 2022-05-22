package com.excentricdevs.presp.controllers;

import com.excentricdevs.presp.models.EnergyData;
import com.excentricdevs.presp.services.EspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/esp")
public class EspController {

    @Autowired
    private EspService espService;

    @PostMapping
    public ResponseEntity<EnergyData> insert(@RequestBody EnergyData energyData) {
        energyData = espService.insert(energyData);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(energyData.getId()).toUri();
        return ResponseEntity.created(uri).body(energyData);
    }
}
