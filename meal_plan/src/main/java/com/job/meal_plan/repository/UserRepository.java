package com.job.meal_plan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.job.meal_plan.model.User;

public interface UserRepository extends JpaRepository<User,String> {
    
}
