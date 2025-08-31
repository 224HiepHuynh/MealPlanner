package com.job.meal_plan.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.User;
import com.job.meal_plan.model.dto.request.UserRequestDto;
import com.job.meal_plan.model.dto.response.UserResponseDto;

public class UserMapper {

    public static UserResponseDto toResponseDto(User user){
       return UserResponseDto.builder()
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



    public static User toUser(UserRequestDto userRequestDto){
        return User.builder()
                .firstName(userRequestDto.getFirstName())
                .lastName(userRequestDto.getLastName())
                .email(userRequestDto.getEmail())
                .pwd(userRequestDto.getPwd())
                .build();
    }
    


}
