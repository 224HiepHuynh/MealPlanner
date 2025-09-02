package com.job.meal_plan.model.dto.response;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponseDto {
    
    private String firstName;

    private String lastName;

    private String email;

    private Set<Long> meals;

    private Set<Long> dayPlans;
}
