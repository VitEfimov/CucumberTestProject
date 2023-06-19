package com.google.utilities.pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;
@Data
@JsonIgnoreProperties(value="id",allowSetters = true)
public class ZippopotamPOJO {

    private String postCode;
    private String country;
    private String countryAbbreviations;
    private Map<String,String> place;
}
