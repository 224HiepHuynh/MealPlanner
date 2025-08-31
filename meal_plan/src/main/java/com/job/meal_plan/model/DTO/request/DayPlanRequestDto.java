package com.job.meal_plan.model.dto.request;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayPlanRequestDto {

    private Long id;
    private String userEmail;
    private String planName;
    private Set<MealRequestDto> meals;
    
    
    
}

