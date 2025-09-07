package com.job.meal_plan.client.dto;

import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsdaSearchFoodsDto {
    // private int totalHits;
    // private int currentPage;
    // private int totalPages;
    // private List<Integer> pageList;
    // // private List<String> foodSearchCriteria;
    // private List<UsdaSRLegacyFoodDto> foods;

    @JsonProperty("totalHits")
    private int totalHits;

    @JsonProperty("currentPage")
    private int currentPage;

    @JsonProperty("totalPages")
    private int totalPages;

    @JsonProperty("pageList")
    private List<Integer> pageList;

    @JsonProperty("foods")
    private List<UsdaSearchFoodsSRLegacyDto> foods;
}
