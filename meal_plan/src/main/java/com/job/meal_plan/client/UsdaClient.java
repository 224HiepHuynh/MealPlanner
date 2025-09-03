package com.job.meal_plan.client;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.job.meal_plan.client.dto.UsdaSRLegacyFoodDto;
import com.job.meal_plan.config.UsdaConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsdaClient {
    

    private final UsdaConfig usdaConfig;
    private final RestTemplate restTemplate;


    public ResponseEntity<UsdaSRLegacyFoodDto> findUsdaFoodById(Long id){

        String url=usdaConfig.urlGetById(String.valueOf(id));
        
        ResponseEntity<UsdaSRLegacyFoodDto> uFoodDto=restTemplate.getForEntity(url,UsdaSRLegacyFoodDto.class);
        return uFoodDto;
    }

    public ResponseEntity<UsdaSRLegacyFoodDto[]>findAllByUsdaId(Set<Long> idList){
        
        String url = usdaConfig.urlGetAllByUsdaIds(idList);
        ResponseEntity<UsdaSRLegacyFoodDto[]> response = restTemplate.getForEntity(url, UsdaSRLegacyFoodDto[].class);
        System.out.println(response.toString());
        return response;
    }
}
