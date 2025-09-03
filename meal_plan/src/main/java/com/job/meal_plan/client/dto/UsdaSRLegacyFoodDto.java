package com.job.meal_plan.client.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsdaSRLegacyFoodDto {
    private Long fdcId;
    private String description;
    private List<UsdaSRLegacyNutrientDto> foodNutrients;
}
