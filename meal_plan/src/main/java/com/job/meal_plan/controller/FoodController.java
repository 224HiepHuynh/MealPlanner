package com.job.meal_plan.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.meal_plan.model.dto.response.FoodResponseDto;
import com.job.meal_plan.service.FoodService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/api/foods")
@RequiredArgsConstructor
public class FoodController {
    

    private final FoodService foodService;


    @GetMapping("/{id}")
    public ResponseEntity<FoodResponseDto> findUsdafoodById(@PathVariable Long id){
        FoodResponseDto fdto= foodService.findUsdafoodById(id);
        return ResponseEntity.ok(fdto);
    }
    
}
