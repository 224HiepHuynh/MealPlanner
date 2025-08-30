package com.job.meal_plan.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodRequestDto {
    
    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer calories;
    private Integer amount;
}
