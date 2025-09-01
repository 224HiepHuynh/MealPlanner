package com.job.meal_plan.service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.job.meal_plan.model.Meal;
import com.job.meal_plan.repository.MealRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public <S extends Meal> Collection<S> saveAll(Collection<S> meals){
        
        return mealRepository.saveAll(meals);
    }
}
