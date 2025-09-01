package com.job.meal_plan.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.Meal;
import com.job.meal_plan.model.MealFood;
import com.job.meal_plan.model.dto.request.DayPlanRequestDto;
import com.job.meal_plan.model.dto.request.FoodRequestDto;
import com.job.meal_plan.model.dto.request.MealRequestDto;
import com.job.meal_plan.model.dto.response.DayPlanDetailedResponseDto;
import com.job.meal_plan.model.dto.response.DayPlanResponseDto;
import com.job.meal_plan.model.mapper.DayPlanMapper;
import com.job.meal_plan.model.mapper.MealMapper;
import com.job.meal_plan.repository.DayPlanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DayPlanService {
    
    private final DayPlanRepository dayPlanRepository;
    private final FoodService foodService;
    private final MealService mealService;

    public Set<DayPlanResponseDto> getAllDayPlansByUserId(String userId){
        
        
        Set<DayPlan> dayplans= dayPlanRepository.findByUserEmail(userId);
        return dayplans.stream()
                .map(dp-> DayPlanMapper.toResponseDto(dp))
                .collect(Collectors.toSet());
    

    }


    public DayPlanDetailedResponseDto updatePlan(Long Id,DayPlanRequestDto dayPlanRequestDto){

        dayPlanRequestDto.setId(Id);

        return DayPlanMapper.toResponseDto(
            dayPlanRepository.save(DayPlanMapper.toDayPlan(dayPlanRequestDto))
            );

    }

    
    public DayPlanDetailedResponseDto createDayPlan(DayPlanRequestDto thePlan) throws Exception{

        DayPlan dp= DayPlanMapper.toDayPlan(thePlan); //DayPlan Obj w/Meals that has empty FoodList

        Set<Long> allFoodIds = thePlan.getMeals().stream()
            .flatMap(mealRequestDtos->mealRequestDtos.getFoodList().stream())
            .map(FoodRequestDto::getId)
            .collect(Collectors.toSet());
        
        Map<Long, Food> foodMap = foodService.findAllById(allFoodIds).stream()
            .collect(Collectors.toMap(Food::getId, f->f));

        if(foodMap.size()!=allFoodIds.size()){throw new Exception("Some Foods don't exist");}

        Set<MealRequestDto> mealRequests= thePlan.getMeals();

        Map<MealRequestDto,Meal> mealMap= 
            mealRequests.stream()
            .collect(Collectors.toMap(mr->mr,MealMapper::toMeal));
        mealService.saveAll(mealMap.values()); 
        for(MealRequestDto mr: mealMap.keySet()){
            Meal meal=mealMap.get(mr);
            for(FoodRequestDto foodRequest: mr.getFoodList()){
                Long key=foodRequest.getId();
                Food food=foodMap.get(key);
                MealFood mf= MealFood.builder()
                    .meal(meal)
                    .food(food)
                    .grams(foodRequest.getAmount())
                    .build();
                meal.getFoodList().add(mf);
            }
        }
        
        dp.setMeals(new HashSet<>(mealMap.values()));
        DayPlan savedDayPlan= dayPlanRepository.save(dp);
        return DayPlanMapper.toDetailedResponseDto(savedDayPlan);

    }





}
