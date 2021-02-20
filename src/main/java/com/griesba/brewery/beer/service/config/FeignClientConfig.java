package com.griesba.brewery.beer.service.config;

import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor (
            @Value("${griesba.brewery.inventory-user}") String inventoryUser,
            @Value("${griesba.brewery.inventory-password}") String inventoryPassword) {
        return new BasicAuthRequestInterceptor (inventoryUser, inventoryPassword);
    }
}
