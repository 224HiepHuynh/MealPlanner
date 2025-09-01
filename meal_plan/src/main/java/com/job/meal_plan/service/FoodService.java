package com.job.meal_plan.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.dto.response.FoodResponseDto;
import com.job.meal_plan.model.mapper.FoodMapper;
import com.job.meal_plan.repository.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodService {
    
    private FoodRepository foodRepository;

    public FoodResponseDto findById(Long id) throws Exception{
        return FoodMapper.toResponseDto(
            foodRepository.findById(id).orElseThrow(()->new Exception("not Found"))
        );
        //to do: make custom Exception
    }

    public List<Food> findAllById(Set<Long> idList){
        return foodRepository.findAllById(idList);
    }

}
