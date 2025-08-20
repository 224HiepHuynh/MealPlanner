package com.job.meal_plan.model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Meal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealName;

    @Transient
    private Integer totalProtein;
    @Transient
    private Integer totalCarbs;
    @Transient
    private Integer totalFats;
    @Transient
    private Integer totalCalories;

  
    @OneToMany(mappedBy="meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealFood> foodList;

   @ManyToOne
   @JoinColumn(name="user_id")
    private User user;
}

