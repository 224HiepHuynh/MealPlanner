package com.job.meal_plan.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsdaSearchSRLegacyNutrientsDto {
    private Integer nutrientId;
    private String nutrientName;
    private Integer nutrientNumber;
    private double value;
    private String unitName;
    private String derivationCode;
    private String derivationDescription;
}
