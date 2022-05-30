package com.excentricdevs.prbase.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class EnergyDataStoragedService {

    @Autowired
    private EnergyDataService energyDataService;

    // valor da taxa do KWH
    private final int tax = 57651;

    public Integer calculateSpent(Integer hours, Integer days) {
        int avarageValue = getAvarageValue();
        return (calculateKwh(avarageValue, hours, days)) * tax;
    }

    public Integer calculateCurrentSpent(Integer value, Integer hours, Integer days) {
        return (calculateKwh(value, hours, days)) * tax;
    }

    private Integer calculateKwh(Integer value, Integer hours, Integer days) {
        return (value * hours * days) / 1000;
    }

//    private Integer convertAmpsToWatts(Integer amps) {
//        return amps * 220;
//    }

    private Integer getAvarageValue() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        Date oldDate = calendar.getTime();

        return energyDataService.getAvarageValuesByDates(oldDate, date);
    }
}
