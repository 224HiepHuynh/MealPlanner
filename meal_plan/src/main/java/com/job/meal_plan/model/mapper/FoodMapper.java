package com.job.meal_plan.model.mapper;

import java.util.stream.Collectors;

import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.MealFood;
import com.job.meal_plan.model.dto.FoodDto;

public class FoodMapper {
    

    public static FoodDto toDto(Food food){
        return FoodDto.builder()
                .id(food.getId())
                .calories(food.getCalories())
                .carbs(food.getCarbs())
                .fats(food.getFats())
                .name(food.getName())
                .protein(food.getProtein())
                .mealFoods(food.getMealFoods()==null?null:food.getMealFoods().stream()
                    .map(f->f.getId())
                    .collect(Collectors.toSet()))
                .build();
    }

    public static Food toFood(FoodDto foodDto){
        return Food.builder()
                .id(foodDto.getId())
                .calories(foodDto.getCalories())
                .carbs(foodDto.getCarbs())
                .fats(foodDto.getFats())
                .name(foodDto.getName())
                .protein(foodDto.getProtein())
                .mealFoods(foodDto.getMealFoods()==null?null:foodDto.getMealFoods().stream()
                    .map(id->MealFood.builder().id(id).build())
                    .collect(Collectors.toSet()))
                .build();

    }
}
