package com.job.meal_plan.model;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Food {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;
    private Integer protein;
    private Integer carbs;
    private Integer fats;
    private Integer calories; 


    
    @OneToMany(mappedBy="food")
    @EqualsAndHashCode.Exclude
    private Set<MealFood> mealFoods;

    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    } 

    @Override
    public boolean equals(Object o){
        if(this==o) return true;
        if(!(o instanceof Food)) return false;
        Food food= (Food) o;
        return id!=null && id.equals(food.getId());
    }
}

