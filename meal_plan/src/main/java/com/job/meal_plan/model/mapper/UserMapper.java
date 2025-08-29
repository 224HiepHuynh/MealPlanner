package com.job.meal_plan.model.mapper;

import java.util.List;
import java.util.Set;
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
            .mealIds( user.getMeals() ==null? Set.of():
                user.getMeals().stream()
                .map(m -> m.getId())
                .collect(Collectors.toSet())
                )
            .dayPlanIds( user.getDayPlans()==null?Set.of():
                user.getDayPlans().stream()
                .map(p->p.getId())
                .collect(Collectors.toSet())
                )
            .build();

    }



    public static User toUser(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .meals(userDto.getMealIds().stream()
                    .map(id->new Meal(id))
                    .collect(Collectors.toSet()))
                .
                
    }
    
}
