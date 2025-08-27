package com.job.meal_plan.model.dto;

import java.util.List;

import lombok.*;

@Builder
@Data
public class MealDto {
    
     
    private Long id;

    private String mealName;

    private Integer totalProtein;
    private Integer totalCarbs;
    private Integer totalFats;
    private Integer totalCalories;
    private List<MealFoodDto> foodList;
    private UserDto user;
}
