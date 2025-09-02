package com.job.meal_plan.config;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsdaConfig {
    
    private String key;
    private String baseUrl;
    private final String format="abridged";
    public String urlGetById(String query){

        // https://api.nal.usda.gov/fdc/v1/foods/search?query=broccoli&api_key=123ABC
        // String encodedQuery= URLEncoder.encode(query, StandardCharsets.UTF_8);
       return String.format("%s/food/%s?api_key=%s&format=%s", baseUrl,query,key,format);
    }


    public String urlGetByNameContainning(String query){
        String encodedQuery= URLEncoder.encode(query, StandardCharsets.UTF_8);
        return String.format("%/foods/search?query=%&api_key=%&format=%", baseUrl,encodedQuery,key,format);
    }


}
