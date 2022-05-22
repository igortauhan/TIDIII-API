package com.excentricdevs.presp.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnergyData {

    private String id;
    private Integer value;
    @JsonProperty("registration_date")
    private Date registrationDate;
}
