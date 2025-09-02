package com.job.meal_plan.model.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FoodResponseDto {
    private Long id;
    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer kcal;
}
