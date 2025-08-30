package com.job.meal_plan.model.dto;

import lombok.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DayPlanDto {
    private Long id;
    private String userEmail;
    private String planName;
    private Set<Long> meals;
}


