package com.job.meal_plan.model.dto;

import java.util.List;

import lombok.*;

@Builder
@Data
public class FoodDto {
    private Long id;


    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer calories; 
    private List<MealFoodDto> mealFood;
}
