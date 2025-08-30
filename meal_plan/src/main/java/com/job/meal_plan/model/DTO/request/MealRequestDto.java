package com.job.meal_plan.model.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealRequestDto {
    

    private String mealName;
    private List<FoodRequestDto> foodList;

}
