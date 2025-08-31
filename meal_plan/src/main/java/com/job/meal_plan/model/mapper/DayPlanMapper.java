package com.job.meal_plan.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.request.DayPlanRequestDto;
import com.job.meal_plan.model.dto.response.DayPlanResponseDto;


public class DayPlanMapper {




    public static DayPlanResponseDto toResponseDto(DayPlan dayPlan){
        return DayPlanResponseDto.builder()
                .id(dayPlan.getId())
                .meals(
                    dayPlan.getMeals()==null?null: dayPlan.getMeals().stream()
                    .map(m->m.getId())
                    .collect(Collectors.toSet()))
                .userEmail(dayPlan.getUser()==null? null:dayPlan.getUser().getEmail())
                .planName(dayPlan.getPlanName())
                .build();
                
    }

    public static DayPlan toDayPlan(DayPlanRequestDto dayPlanRequestDto){
        return DayPlan.builder()
                .user(User.builder().
                    email(dayPlanRequestDto.getUserEmail())
                    .build())
                .meals(Set.of())
                .planName(dayPlanRequestDto.getPlanName())
                .build();
    }



    
}
