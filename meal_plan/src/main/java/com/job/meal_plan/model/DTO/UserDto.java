package com.job.meal_plan.model.dto;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;


@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {
    
    private String firstName;

    private String lastName;

    private String email;

    private String pwd;

    private Set<Long> meals;

    private Set<Long> dayPlans;
}
