package com.job.meal_plan.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsdaSRLegacyNutrientDto {
    private int number;
    private String name;
    private double amount;
    private String unitName;
}
