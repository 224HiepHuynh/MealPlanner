package com.job.meal_plan.model.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MealResponseDto {
    
     
    private Long id;

    private String mealName;

    private Integer totalProtein;
    private Integer totalCarbs;
    private Integer totalFats;
    private Integer totalCalories;
    private Set<Long> mealFoods;
    private String user;
}
