package com.job.meal_plan.model;
import jakarta.persistence.*;
import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class MealFood {
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="meal_id")
    @EqualsAndHashCode.Exclude
    private Meal meal;

    @ManyToOne
    @JoinColumn(name="food_id")
    @EqualsAndHashCode.Exclude
    private Food food;

    private Integer grams;
}
