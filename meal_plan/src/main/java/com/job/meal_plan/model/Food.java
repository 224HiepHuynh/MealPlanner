package com.job.meal_plan.model;
import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.GeneratedValue;
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
    private List<MealFood> mealFood;


}

