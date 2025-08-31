package com.job.meal_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.meal_plan.model.MealFood;

public interface MealFoodRepository extends JpaRepository<MealFood,Long> {
    
}
