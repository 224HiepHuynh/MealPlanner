package com.job.meal_plan.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class DayPlan {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Transient
    private Integer totalDayProtein;
    @Transient
    private Integer totalDayCarbs;
    @Transient
    private Integer totalDayFats;
    @Transient
    private Integer totalDayCalories;

    
    @ManyToMany
    @JoinTable(
        name="Day_plan_meal",
        joinColumns=@JoinColumn(name="Day_plan_id"),
        inverseJoinColumns=@JoinColumn(name="meal_id")
    )
    private List<Meal> meals;
    

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
