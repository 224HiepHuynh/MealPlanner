package com.job.meal_plan.model.dto.response;

import lombok.*;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DayPlanDetailedResponseDto {
    private Long id;
    private String userEmail;
    private String planName;
    private Set<MealInPlanResponseDTO> meals;
}


