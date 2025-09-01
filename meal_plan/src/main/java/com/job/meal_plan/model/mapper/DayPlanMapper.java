package com.job.meal_plan.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.request.DayPlanRequestDto;
import com.job.meal_plan.model.dto.response.DayPlanDetailedResponseDto;
import com.job.meal_plan.model.dto.response.DayPlanResponseDto;

public class DayPlanMapper {




    public static DayPlanDetailedResponseDto toDetailedResponseDto(DayPlan dayPlan){
        return DayPlanDetailedResponseDto.builder()
                .id(dayPlan.getId())
                .meals(
                    dayPlan.getMeals()==null?null: dayPlan.getMeals().stream()
                    .map(MealMapper::toMealInPlanResponseDto)
                    .collect(Collectors.toSet()))
                .userEmail(dayPlan.getUser()==null? null:dayPlan.getUser().getEmail())
                .planName(dayPlan.getPlanName())
                .build();
                
    }

    public static DayPlan toDayPlan(DayPlanRequestDto dayPlanRequestDto){
        return DayPlan.builder()
                .id(dayPlanRequestDto.getId())
                .user(User.builder().
                    email(dayPlanRequestDto.getUserEmail())
                    .build())
                .meals(dayPlanRequestDto.getMeals()==null?null:dayPlanRequestDto.getMeals().stream()
                    .map(mr->MealMapper.toMeal(mr))
                    .collect(Collectors.toSet()))
                .planName(dayPlanRequestDto.getPlanName())
                .build();
    }


      public static DayPlanResponseDto toResponseDto(DayPlan dayPlan){
        return DayPlanResponseDto.builder()
                .id(dayPlan.getId())
                .meals(
                    dayPlan.getMeals()==null?Set.of(): dayPlan.getMeals().stream()
                    .map(Meal::getId)
                    .collect(Collectors.toSet()))
                .userEmail(dayPlan.getUser()==null? null:dayPlan.getUser().getEmail())
                .planName(dayPlan.getPlanName())
                .build();
                
    }
    
}
