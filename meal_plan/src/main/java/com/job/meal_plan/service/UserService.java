package com.job.meal_plan.service;

import org.springframework.stereotype.Service;

import com.job.meal_plan.repository.MealRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final MealRepository mealRepository;
}
