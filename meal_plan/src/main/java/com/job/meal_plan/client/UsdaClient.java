package com.job.meal_plan.client;


import java.util.Set;


import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.job.meal_plan.client.dto.UsdaSRLegacyFoodDto;
import com.job.meal_plan.client.dto.UsdaSearchFoodsDto;
import com.job.meal_plan.config.UsdaConfig;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsdaClient {
    

    private final UsdaConfig usdaConfig;
    private final RestTemplate restTemplate;

    public ResponseEntity<UsdaSRLegacyFoodDto> findSRLegacyUsdaFoodById(Long id){

        String url=usdaConfig.urlGetById(String.valueOf(id));
        
        ResponseEntity<UsdaSRLegacyFoodDto> uFoodDto=restTemplate.getForEntity(url,UsdaSRLegacyFoodDto.class);
        return uFoodDto;
    }

    public ResponseEntity<UsdaSRLegacyFoodDto[]>findAllBySRLegacyUsdaId(Set<Long> idList){
        
        String url = usdaConfig.urlGetAllBySRLegacyUsdaIds(idList);
        ResponseEntity<UsdaSRLegacyFoodDto[]> response = restTemplate.getForEntity(url, UsdaSRLegacyFoodDto[].class);
        // System.out.println(response.toString());
        return response;
    }

    public ResponseEntity<UsdaSearchFoodsDto> findBySRLegacyNameContainning(String query){
        String url= usdaConfig.urlGetBySRLegacyNameContainning(query);

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        // headers.set("User-Agent", "Mozilla/5.0"); // mimic browser
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<UsdaSearchFoodsDto> response =
            restTemplate.exchange(url, HttpMethod.GET, entity, UsdaSearchFoodsDto.class);

        return response;
    }

}
