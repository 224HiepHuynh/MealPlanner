package com.job.meal_plan.model.dto;

import java.util.*;

import lombok.*;


@Builder
@Data
public class UserDto {
    
    private String firstName;

    private String lastName;

    private String email;

    private String pwd;

    private Set<Long> mealIds;

    private Set<Long> dayPlanIds;
}
