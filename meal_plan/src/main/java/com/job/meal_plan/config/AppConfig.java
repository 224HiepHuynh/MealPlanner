package com.job.meal_plan.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    // @Bean
    // public DataSource dataSource(
    //     @Value("${spring.datasource.url}") String url,
    //     @Value("${spring.datasource.driver-class-name}") String driverClassName,
    //     @Value("${spring.datasource.username}") String username,
    //     @Value("${spring.datasource.password}") String password) {

    //     return DataSourceBuilder.create()
    //             .url(url)
    //             .driverClassName(driverClassName)
    //             .username(username)
    //             .password(password)
    //             .build();
    // }

    @Bean
    public UsdaConfig usdaConfig(
        @Value("${app.usda.api.key}") String key,
        @Value("${app.usda.api.base-url}") String baseUrl){

        return UsdaConfig.builder()
            .key(key)
            .baseUrl(baseUrl)
            .build();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    

}

