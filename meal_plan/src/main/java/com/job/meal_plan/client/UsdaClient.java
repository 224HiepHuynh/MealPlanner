package com.job.meal_plan.client;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.job.meal_plan.client.dto.UsdaFoodDto;
import com.job.meal_plan.config.UsdaConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsdaClient {
    

    private final UsdaConfig usdaConfig;
    private final RestTemplate restTemplate;


    public ResponseEntity<UsdaFoodDto> findUsdaFoodById(Long id){

        String url=usdaConfig.urlGetById(String.valueOf(id));
        
        ResponseEntity<UsdaFoodDto> uFoodDto=restTemplate.getForEntity(url,UsdaFoodDto.class);
        return uFoodDto;
    }


}
