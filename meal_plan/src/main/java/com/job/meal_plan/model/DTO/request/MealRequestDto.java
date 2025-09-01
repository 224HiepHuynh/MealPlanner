package com.job.meal_plan.model.dto.request;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealRequestDto {
    
    private Long id;
    private String mealName;
    private Set<FoodRequestDto> foodList;

}
