package com.excentricdevs.prbase.controllers;

import com.excentricdevs.prbase.services.EnergyDataStoragedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/storaged")
public class EnergyDataStoragedController {

    @Autowired
    private EnergyDataStoragedService energyDataStoragedService;

    @GetMapping(value = "/spent")
    public Integer getSpent(@RequestParam Integer hours, @RequestParam Integer days) {
        return energyDataStoragedService.calculateSpent(hours, days);
    }

    @GetMapping(value = "/current-spent")
    public Integer getCurrentSpent(@RequestParam Integer value, @RequestParam Integer hours, @RequestParam Integer days) {
        return energyDataStoragedService.calculateCurrentSpent(value, hours, days);
    }
}
