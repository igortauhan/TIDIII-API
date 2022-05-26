package com.excentricdevs.prbase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class EnergyDataStoragedService {

    @Autowired
    private EnergyDataService energyDataService;

    public Integer calculateSpent(Integer hours, Integer days) {
        // valor da taxa do KWH
        int tax = 57651;
        int avarageValue = getAvarageValue();
        return calculateKwh(avarageValue, hours, days);
    }

    private Integer calculateKwh(Integer avarageValue, Integer hours, Integer days) {
        return (avarageValue * hours * days) / 1000;
    }

    private Integer getAvarageValue() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date oldDate = calendar.getTime();

        return energyDataService.getAvarageValuesByDates(oldDate, date);
    }
}
