package com.job.meal_plan.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MealFoodDto {

    private Long id;

    private Long meal;

    private Long food;
    private Integer grams;
    
    
}
