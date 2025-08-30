package com.job.meal_plan.model.mapper;

import java.util.stream.Collectors;

import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.MealFood;
import com.job.meal_plan.model.dto.MealDto;

public class MealMapper {
    

    public static MealDto toDto(Meal meal){

        return MealDto.builder()
                .id(meal.getId())
                .mealName(meal.getMealName())
                .mealFoods( meal.getFoodList()== null?null:meal.getFoodList().stream()
                    .map(mf->mf.getId())
                    .collect(Collectors.toSet()))
                .user(meal.getUser()==null?null:meal.getUser().getEmail())
                .build();
    }

    public static Meal toMeal(MealDto mealDto){
        return Meal.builder()
                .id(mealDto.getId())
                .mealName(mealDto.getMealName())
                .foodList(mealDto.getMealFoods()==null?null:mealDto.getMealFoods().stream()
                    .map(id -> MealFood.builder().id(id).build())
                    .collect(Collectors.toSet()))
                .build();
    }



}
