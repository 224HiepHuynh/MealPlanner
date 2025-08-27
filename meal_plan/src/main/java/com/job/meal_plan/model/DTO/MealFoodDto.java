package com.job.meal_plan.model.dto;


import lombok.*;

@Builder
@Data
public class MealFoodDto {

    private Long id;

    private MealDto meal;

    private FoodDto food;
    private Integer grams;
    
    
}
