package com.job.meal_plan.service;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
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
import com.job.meal_plan.model.dto.response.FoodResponseDto;
import com.job.meal_plan.model.mapper.DayPlanMapper;
import com.job.meal_plan.model.mapper.MealMapper;
import com.job.meal_plan.repository.DayPlanRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

    @Transactional
    public DayPlanDetailedResponseDto updatePlan(DayPlanRequestDto dayPlanRequestDto){

        DayPlan plan = dayPlanRepository.findById(dayPlanRequestDto.getId())
        .orElseThrow(() -> new EntityNotFoundException("DayPlan not found with id " + dayPlanRequestDto.getId()));

        Set<Meal> m=plan.getMeals();
        


        return DayPlanMapper.toDetailedResponseDto(
            dayPlanRepository.save(DayPlanMapper.toDayPlan(dayPlanRequestDto))
            );



    }

    @Transactional
    public DayPlanDetailedResponseDto findById(Long id){
        return DayPlanMapper.toDetailedResponseDto(
            dayPlanRepository.findById(id)
            .orElseThrow(()-> new EntityNotFoundException("Doesn't Exist"))
            );
    }

    @Transactional
    public DayPlanDetailedResponseDto createDayPlan(DayPlanRequestDto thePlan) throws Exception{
        
        Set<MealRequestDto> mealRequests= thePlan.getMeals();
        boolean sameUser=true;
        for(MealRequestDto m: mealRequests){
            sameUser=m.getUserEmail().equals(thePlan.getUserEmail());
        }
        if(!sameUser) throw new Exception("bad request: userId");

        DayPlan dp= DayPlanMapper.toDayPlan(thePlan); //DayPlan Obj w/Meals that has empty FoodList

        Set<Long> allFoodIds = thePlan.getMeals().stream()
            .flatMap(mealRequestDtos->mealRequestDtos.getFoodList().stream())
            .map(FoodRequestDto::getId)
            .collect(Collectors.toSet());

        Map<Long, Food> foodMap = foodService.findAllById(allFoodIds).stream()
            .collect(Collectors.toMap(Food::getId, f->f));
        
        Set<Long> usdaFoodIds=foodService.findAllByUsdaId(allFoodIds).stream()
            .map(FoodResponseDto::getId)
            .collect(Collectors.toSet());
        
        if(foodMap.size()+usdaFoodIds.size()!=allFoodIds.size()){throw new Exception("Some Foods don't exist");}


        Map<MealRequestDto,Meal> mealMap= 
            mealRequests.stream()
            .collect(Collectors.toMap(mr->mr,MealMapper::toMeal));
    
        mealService.saveAll(mealMap.values()); 
        for(MealRequestDto mr: mealMap.keySet()){
            Meal meal=mealMap.get(mr);
            for(FoodRequestDto foodRequest: mr.getFoodList()){
                Long key=foodRequest.getId();
                Food food=foodMap.get(key);
                MealFood mf=null;
                if(foodMap.containsKey(key)){
                     mf= MealFood.builder()
                    .meal(meal)
                    .food(food)
                    .grams(foodRequest.getAmount())
                    .build();
                }
                else if(usdaFoodIds.contains(key)){
                    mf= MealFood.builder()
                    .meal(meal)
                    .food(null)
                    .grams(foodRequest.getAmount())
                    .usdaId(key)
                    .build();
                }
                meal.getFoodList().add(mf);
            }
        }
        
        dp.setMeals(new HashSet<>(mealMap.values()));
        DayPlan savedDayPlan= dayPlanRepository.save(dp);
        return DayPlanMapper.toDetailedResponseDto(savedDayPlan);

    }





}
