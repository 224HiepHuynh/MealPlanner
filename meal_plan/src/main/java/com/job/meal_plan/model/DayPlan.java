package com.job.meal_plan.model;

import java.util.HashSet;
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
    
    @OneToMany(mappedBy="dayPlan", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private Set<Meal> meals;
    

    @ManyToOne
    @JoinColumn(name="user_id")
    @EqualsAndHashCode.Exclude
    private User user;


    public void addMeal(Meal meal){
        meals.add(meal);
        meal.setDayPlan(this);
    }
    
    
    public void setMeals(Set<Meal> newMeals){
        if(newMeals==null){
            meals=new HashSet<>();
            return;
        }
        for(Meal nm:newMeals){
            nm.setDayPlan(this);
        }
        this.meals=newMeals;
    }

    public void removeMeal(Meal meal) {
        meals.remove(meal);
        meal.setDayPlan(null);
    }

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
