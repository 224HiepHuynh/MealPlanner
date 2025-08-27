package com.job.meal_plan.model.dto;

import java.util.List;

import lombok.*;


@Builder
@Data
public class UserDto {
    
    private String firstName;

    private String lastName;

    private String email;

    private String pwd;

    private List<Long> mealIds;

    private List<Long> dayPlanIds;
}
