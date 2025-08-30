package com.job.meal_plan.model;

import java.util.Set;

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
    private Long id;
    
    @Transient
    private Integer totalDayProtein;
    @Transient
    private Integer totalDayCarbs;
    @Transient
    private Integer totalDayFats;
    @Transient
    private Integer totalDayCalories;

    private String planName;
    
    @ManyToMany
    @JoinTable(
        name="Day_plan_meal",
        joinColumns=@JoinColumn(name="Day_plan_id"),
        inverseJoinColumns=@JoinColumn(name="meal_id")
    )
    @EqualsAndHashCode.Exclude
    private Set<Meal> meals;
    

    @ManyToOne
    @JoinColumn(name="user_id")
    @EqualsAndHashCode.Exclude
    private User user;


    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DayPlan)) return false;
        DayPlan other = (DayPlan) o;
        return id != null && id.equals(other.getId());
    }
}
