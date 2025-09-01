package com.job.meal_plan.model.dto.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;


@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MealInPlanResponseDTO {
    private Long id;
    private String mealName;
    private Integer totalProtein;
    private Integer totalCarbs;
    private Integer totalFats;
    private Integer totalCalories;
    private Set<FoodResponseDto> mealFoods;
}
