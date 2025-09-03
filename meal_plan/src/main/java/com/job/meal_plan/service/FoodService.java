package com.job.meal_plan.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.job.meal_plan.client.UsdaClient;
import com.job.meal_plan.client.dto.UsdaSRLegacyFoodDto;
import com.job.meal_plan.model.Food;
import com.job.meal_plan.model.dto.response.FoodResponseDto;
import com.job.meal_plan.model.mapper.FoodMapper;
import com.job.meal_plan.repository.FoodRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodService {
    
    private final FoodRepository foodRepository;
    private final UsdaClient usdaClient;


    public FoodResponseDto findById(Long id) throws Exception{
        return FoodMapper.toResponseDto(
            foodRepository.findById(id).orElseThrow(()->new Exception("not Found"))
        );
        //to do: make custom Exception
    }

    public List<Food> findAllById(Set<Long> idList){
        return foodRepository.findAllById(idList);
    }


    public FoodResponseDto findUsdafoodById(Long id){
       ResponseEntity<UsdaSRLegacyFoodDto> uFoodDto= usdaClient.findUsdaFoodById(id);
        
       return FoodMapper.usdaFoodToFoodResponseDto(uFoodDto.getBody());

    }

     public Set<FoodResponseDto> findAllByUsdaId(Set<Long> idList){
        
        ResponseEntity<UsdaSRLegacyFoodDto[]> response =usdaClient.findAllByUsdaId(idList);
        UsdaSRLegacyFoodDto[] foods=response.getBody();
        if (foods==null){
            return new HashSet<>();
        }
        return Arrays.asList(foods).stream()
            .map(FoodMapper::usdaFoodToFoodResponseDto)
            .collect(Collectors.toSet());
    }

}

