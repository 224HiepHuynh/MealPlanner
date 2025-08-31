package com.job.meal_plan.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.job.meal_plan.model.DayPlan;
import com.job.meal_plan.model.Food;

public interface DayPlanRepository extends JpaRepository<DayPlan,Long>{
    Set<Food> findByDayPlanNameContaining(String keyword);
}
