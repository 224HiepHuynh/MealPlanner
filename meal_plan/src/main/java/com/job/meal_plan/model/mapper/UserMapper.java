package com.job.meal_plan.model.mapper;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user){
       return UserDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .mealIds( user.getMeals() ==null? List.of():
                user.getMeals().stream()
                .map(m -> m.getId())
                .collect(Collectors.toList())
                )
            .dayPlanIds( user.getDayPlans()==null?List.of():
                user.getDayPlans().stream()
                .map(p->p.getId())
                .collect(Collectors.toList())
                )
            .build();

    }
    
}
