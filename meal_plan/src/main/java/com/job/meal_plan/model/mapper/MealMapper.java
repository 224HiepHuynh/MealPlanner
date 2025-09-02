package com.job.meal_plan.model.mapper;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.request.MealRequestDto;
import com.job.meal_plan.model.dto.response.MealInPlanResponseDTO;
import com.job.meal_plan.model.dto.response.MealResponseDto;

public class MealMapper {
    

    public static MealResponseDto toResponseDto(Meal meal){

        return MealResponseDto.builder()
                .id(meal.getId())
                .mealName(meal.getMealName())
                .mealFoods( meal.getFoodList()== null?new HashSet<>():meal.getFoodList().stream()
                    .map(mf->FoodMapper.toResponseDto(mf.getFood()))
                    .collect(Collectors.toSet()))
                .user(meal.getUser()==null?null:meal.getUser().getEmail())
                .build();
    }

    public static Meal toMeal(MealRequestDto mealRequestDto){
        return Meal.builder()
                .id(mealRequestDto.getId())
                .user(User.builder().email(mealRequestDto.getUserEmail()).build())
                .mealName(mealRequestDto.getMealName())
                .foodList(new HashSet<>())
                .build();
    }


    public static MealInPlanResponseDTO toMealInPlanResponseDto(Meal meal){

        return MealInPlanResponseDTO.builder()
                .id(meal.getId())
                .mealName(meal.getMealName())
                .mealFoods( meal.getFoodList()== null?new HashSet<>():meal.getFoodList().stream()
                    .map(mf->FoodMapper.toResponseDto(mf.getFood()))
                    .collect(Collectors.toSet()))
                .build();
    }


    

}
