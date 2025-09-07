package com.job.meal_plan.config;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.stream.Collectors;

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


    public String urlGetBySRLegacyNameContainning(String query){
        /*
         
            curl -X 'GET' \
            '%foods/search?query=%s&dataType=SR%20Legacy&pageSize=1&pageNumber=1&sortBy=fdcId&sortOrder=asc&api_key=%s' \
            -H 'accept: application/json'
         
         */
        // String encodedQuery= URLEncoder.encode(query, StandardCharsets.UTF_8);
        return String.format("%s/foods/search?query=%s&dataType=SR Legacy&pageSize=10&pageNumber=0&sortBy=fdcId&sortOrder=asc&api_key=%s", baseUrl,query,key);
    }

    public String urlGetAllBySRLegacyUsdaIds(Collection<?> idList){

        String paramList= idList.stream()
            .map(id->String.valueOf(id))
            .collect(Collectors.joining("&fdcIds="));

        return String.format("%s/foods?fdcIds=%s&format=%s&nutrients=204&nutrients=205&nutrients=203&nutrients=208&api_key=%s", baseUrl,paramList,format,key);
    }

    

}
