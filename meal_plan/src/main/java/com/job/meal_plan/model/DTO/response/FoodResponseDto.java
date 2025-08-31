package com.job.meal_plan.model.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodResponseDto {
    private Long id;
    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer calories; 
    private Set<Long> mealFoods;
}
