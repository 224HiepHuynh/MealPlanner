package com.job.meal_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.Meal;
import java.util.Set;


@Repository
public interface MealRepository extends JpaRepository<Meal,Long>{

    Set<Meal> findByMealName(String Meal);

    Set<Food> findByMealNameContaining(String keyword);

} 
