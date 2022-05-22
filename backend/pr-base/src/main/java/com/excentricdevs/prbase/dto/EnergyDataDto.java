package com.excentricdevs.prbase.dto;

import com.excentricdevs.prbase.models.EnergyData;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class EnergyDataDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    @NotNull(message = "O valor do gasto não pode ser nulo!")
    @NotBlank(message = "O valor do gasto nào pode ser nulo!")
    private Integer value;
    @JsonProperty("registration_date")
    private Date registrationDate;

    public EnergyDataDto(EnergyData energyData) {
        this.id = energyData.getId();
        this.value = energyData.getValue();
        this.registrationDate = energyData.getRegistrationDate();
    }
}
