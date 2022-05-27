package com.excentricdevs.prbase.controllers;

import com.excentricdevs.prbase.models.dto.EnergyDataDto;
import com.excentricdevs.prbase.services.EnergyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/energy")
public class EnergyDataController {

    @Autowired
    private EnergyDataService energyDataService;

    @GetMapping
    public ResponseEntity<Page<EnergyDataDto>> findAll(@PageableDefault(size = 30) Pageable pageable) {
        return ResponseEntity.ok(energyDataService.findAll(pageable));
    }

    @GetMapping(value = "/last")
    public ResponseEntity<EnergyDataDto> findLastRecord() {
        return ResponseEntity.ok(energyDataService.findLastRecord());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnergyDataDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(energyDataService.findById(id));
    }

    @PostMapping
    public ResponseEntity<EnergyDataDto> insert(@RequestBody @Valid EnergyDataDto energyDataDto) {
        energyDataDto = energyDataService.insert(energyDataDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(energyDataDto.getId()).toUri();
        return ResponseEntity.created(uri).body(energyDataDto);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EnergyDataDto> update(@RequestBody @Valid EnergyDataDto energyDataDto, @PathVariable String id) {
        energyDataDto = energyDataService.update(energyDataDto, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        energyDataService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
