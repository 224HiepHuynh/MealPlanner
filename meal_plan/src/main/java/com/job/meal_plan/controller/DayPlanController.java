package com.job.meal_plan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.job.meal_plan.model.dto.request.DayPlanRequestDto;
import com.job.meal_plan.model.dto.response.DayPlanDetailedResponseDto;
import com.job.meal_plan.model.dto.response.DayPlanResponseDto;
import com.job.meal_plan.service.DayPlanService;

import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.Set;

import javax.swing.text.html.parser.Entity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/api/dayplans")
@RequiredArgsConstructor
public class DayPlanController {
    
    private final DayPlanService dayPlanService;

    @GetMapping
    public ResponseEntity<Set<DayPlanResponseDto>> getAllDayPlansByUserId(
        @RequestParam("userId") String userId) {
            Set<DayPlanResponseDto> res=dayPlanService.getAllDayPlansByUserId(userId);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/put")
    public ResponseEntity<DayPlanDetailedResponseDto> updatePlan(
        @RequestBody DayPlanRequestDto thePlan){
            return ResponseEntity.ok(dayPlanService.updatePlan(thePlan));
    }


    @PostMapping
    public ResponseEntity<DayPlanDetailedResponseDto> createDayPlan(
        @RequestBody DayPlanRequestDto thePlan) throws Exception{
        
            DayPlanDetailedResponseDto newPlan= dayPlanService.createDayPlan(thePlan);
        return ResponseEntity
            .created(URI.create("/api/dayplans/"+newPlan.getId()))
            .body(newPlan);
    }
    
    
    
}
