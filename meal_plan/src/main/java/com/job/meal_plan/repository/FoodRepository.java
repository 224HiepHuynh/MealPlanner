package com.job.meal_plan.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.meal_plan.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food,Long> {
    
    Set<Food> findByFoodName(String foodName);

    Set<Food> findByFoodNameContaining(String keyword);
}
