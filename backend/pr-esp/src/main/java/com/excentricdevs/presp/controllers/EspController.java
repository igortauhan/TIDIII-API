package com.excentricdevs.presp.controllers;

import com.excentricdevs.presp.dto.EnergyDataDto;
import com.excentricdevs.presp.services.EspService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/esp")
public class EspController {

    @Autowired
    private EspService espService;

    @PostMapping
    public ResponseEntity<EnergyDataDto> insert(@RequestBody @Valid EnergyDataDto energyDataDto) {
        energyDataDto = espService.insert(energyDataDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(energyDataDto.getId()).toUri();
        return ResponseEntity.created(uri).body(energyDataDto);
    }
}
