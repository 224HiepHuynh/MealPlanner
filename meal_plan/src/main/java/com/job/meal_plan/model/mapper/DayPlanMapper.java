package com.job.meal_plan.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.DayPlanDto;

public class DayPlanMapper {




    public static DayPlanDto toDto(DayPlan dayPlan){
        return DayPlanDto.builder()
                .id(dayPlan.getId())
                .meals(
                    dayPlan.getMeals()==null?null: dayPlan.getMeals().stream()
                    .map(m->m.getId())
                    .collect(Collectors.toSet()))
                .userEmail(dayPlan.getUser()==null? null:dayPlan.getUser().getEmail())
                .planName(dayPlan.getPlanName())
                .build();
                
    }

    public static DayPlan toDayPlan(DayPlanDto dayPlanDto){
        return DayPlan.builder()
                .id(dayPlanDto.getId())
                .user(User.builder().
                    email(dayPlanDto.getUserEmail())
                    .build())
                .meals(
                   dayPlanDto.getMeals()==null?Set.of():dayPlanDto.getMeals().stream()
                   .map(id->Meal.builder().id(id).build())
                   .collect(Collectors.toSet()))
                .planName(dayPlanDto.getPlanName())
                .build();
    }



    
}
