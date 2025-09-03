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


    public String urlGetByNameContainning(String query){
        String encodedQuery= URLEncoder.encode(query, StandardCharsets.UTF_8);
        return String.format("%s/foods/search?query=%s&api_key=%s&format=%s", baseUrl,encodedQuery,key,format);
    }

    public String urlGetAllByUsdaIds(Collection<?> idList){

        String paramList= idList.stream()
            .map(id->String.valueOf(id))
            .collect(Collectors.joining("&fdcIds="));

        return String.format("%s/foods?fdcIds=%s&format=%s&nutrients=204&nutrients=205&nutrients=203&nutrients=208&api_key=%s", baseUrl,paramList,format,key);
    }

}
