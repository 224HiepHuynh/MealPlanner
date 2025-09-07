package com.job.meal_plan.model.mapper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import com.job.meal_plan.client.dto.UsdaSRLegacyFoodDto;
import com.job.meal_plan.client.dto.UsdaSRLegacyNutrientDto;
import com.job.meal_plan.client.dto.UsdaSearchFoodsSRLegacyDto;
import com.job.meal_plan.client.dto.UsdaSearchSRLegacyNutrientsDto;
import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.dto.request.FoodRequestDto;
import com.job.meal_plan.model.dto.response.FoodResponseDto;

public class FoodMapper {
    

    public static FoodResponseDto toResponseDto(Food food){
        if(food==null) return null;
        return FoodResponseDto.builder()
                .id(food.getId())
                .kcal(food.getCalories())
                .carbs(food.getCarbs())
                .fats(food.getFats())
                .name(food.getName())
                .protein(food.getProtein())
                .build();
    }

    public static Food toFood(FoodRequestDto foodDto){
        if(foodDto==null) return null;
        return Food.builder()
                .calories(foodDto.getCalories())
                .carbs(foodDto.getCarbs())
                .fats(foodDto.getFats())
                .name(foodDto.getName())
                .protein(foodDto.getProtein())
                .mealFoods(new HashSet<>())
                .build();

    }


    public static FoodResponseDto usdaFoodToFoodResponseDto(UsdaSRLegacyFoodDto usdaFoodDto){
        Map<Integer, UsdaSRLegacyNutrientDto> nutrientMap= usdaFoodDto.getFoodNutrients().stream()
            .collect(Collectors.toMap(n->n.getNumber(), n->n));
        
        /*
        Ids:
        208 → Energy (kcal)
        203 → Protein
        204 → Fat
        205 → Carbs 
        */
        Integer proteinId= 203;
        Integer fatId=204;
        Integer carbId=205;
        Integer calorieId=208;
            return FoodResponseDto.builder()
            .id(usdaFoodDto.getFdcId())
            .name(usdaFoodDto.getDescription())
            .protein(nutrientMap.get(proteinId)==null?0:
                (int) nutrientMap.get(proteinId).getAmount())
            .carbs(nutrientMap.get(carbId)==null?0:
                (int)nutrientMap.get(carbId).getAmount())
            .fats(nutrientMap.get(fatId)==null?0:
                (int)nutrientMap.get(fatId).getAmount())
            .kcal(nutrientMap.get(calorieId)==null?0:
                (int)nutrientMap.get(calorieId).getAmount())
            .build();
    }

    public static Set<FoodResponseDto> toSetOfFoodResponseDtos(UsdaSRLegacyFoodDto[] foods){
        if (foods==null){
            return new HashSet<>();
        }
        return Arrays.asList(foods).stream()
            .map(FoodMapper::usdaFoodToFoodResponseDto)
            .collect(Collectors.toSet());
    }
    

    public static FoodResponseDto usdaFoodToFoodResponseDto(UsdaSearchFoodsSRLegacyDto usdaFoodDto){
        Map<Integer, UsdaSearchSRLegacyNutrientsDto> nutrientMap= usdaFoodDto.getFoodNutrients().stream()
            .collect(Collectors.toMap(n->n.getNutrientNumber(), n->n));
        
        /*
        Ids:
        208 → Energy (kcal)
        203 → Protein
        204 → Fat
        205 → Carbs 
        */
        Integer proteinId= 203;
        Integer fatId=204;
        Integer carbId=205;
        Integer calorieId=208;
            return FoodResponseDto.builder()
            .id(usdaFoodDto.getFdcId())
            .name(usdaFoodDto.getDescription())
            .protein(nutrientMap.get(proteinId)==null?0:
                (int) nutrientMap.get(proteinId).getValue())
            .carbs(nutrientMap.get(carbId)==null?0:
                (int)nutrientMap.get(carbId).getValue())
            .fats(nutrientMap.get(fatId)==null?0:
                (int)nutrientMap.get(fatId).getValue())
            .kcal(nutrientMap.get(calorieId)==null?0:
                (int)nutrientMap.get(calorieId).getValue())
            .build();
    }
    // return null;
}
