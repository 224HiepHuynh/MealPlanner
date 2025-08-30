package com.job.meal_plan.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user){
       return UserDto.builder()
            .firstName(user.getFirstName())
            .lastName(user.getLastName())
            .email(user.getEmail())
            .meals( user.getMeals() ==null? Set.of():
                user.getMeals().stream()
                .map(m -> m.getId())
                .collect(Collectors.toSet())
                )
            .dayPlans( user.getDayPlans()==null?Set.of():
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
                .pwd(userDto.getPwd())
                .meals(userDto.getMeals()==null?Set.of(): userDto.getMeals().stream()
                    .map(id->Meal.builder().id(id).build())
                    .collect(Collectors.toSet()))
                .dayPlans(userDto.getDayPlans()==null?Set.of():userDto.getDayPlans().stream()
                    .map(id-> DayPlan.builder().id(id).build())
                    .collect(Collectors.toSet())    
                )
                .build();
    }
    
}
