package com.job.meal_plan.model;

import java.util.Set;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {
    

    private String firstName;

    private String lastName;

    @Id
    @Column(unique=true)
    private String email;

    private String pwd;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Meal> meals;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<DayPlan> dayPlans;

    
    @Override
    public int hashCode(){
        return email.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User other = (User) o;
        return email != null && email.equals(other.getEmail());
    }
}
