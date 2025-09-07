package com.job.meal_plan.client.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsdaSearchFoodsSRLegacyDto {
    private Long fdcId;
    private String description;
    private String dataType;
    private List<UsdaSearchSRLegacyNutrientsDto> foodNutrients;


}
