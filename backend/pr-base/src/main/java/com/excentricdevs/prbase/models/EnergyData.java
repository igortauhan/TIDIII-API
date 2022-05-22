package com.excentricdevs.prbase.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Document
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EnergyData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private Integer value;
    @JsonProperty("registration_date")
    private Date registrationDate;
}
