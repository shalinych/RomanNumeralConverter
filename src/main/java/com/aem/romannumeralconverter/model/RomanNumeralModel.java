package com.aem.romannumeralconverter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RomanNumeralModel {

    private String input;
    private String output;
}
