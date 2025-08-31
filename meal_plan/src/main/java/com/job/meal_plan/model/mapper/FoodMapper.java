package com.job.meal_plan.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.dto.FoodResponseDto;
import com.job.meal_plan.model.dto.request.FoodRequestDto;

public class FoodMapper {
    

    public static FoodResponseDto toResponseDto(Food food){
        return FoodResponseDto.builder()
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

    public static Food toFood(FoodRequestDto foodDto){
        return Food.builder()
                .calories(foodDto.getCalories())
                .carbs(foodDto.getCarbs())
                .fats(foodDto.getFats())
                .name(foodDto.getName())
                .protein(foodDto.getProtein())
                .mealFoods(Set.of())
                .build();

    }
}
