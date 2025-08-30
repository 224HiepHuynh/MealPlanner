package com.job.meal_plan.model.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanRequestDto {


    private String userEmail;
    private String planName;
    private List<MealRequestDto> meals;
    
}
