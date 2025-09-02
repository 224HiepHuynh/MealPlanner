package com.job.meal_plan.model.dto.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
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
