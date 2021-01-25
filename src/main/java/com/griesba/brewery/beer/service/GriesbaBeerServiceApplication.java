package com.griesba.brewery.beer.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class GriesbaBeerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GriesbaBeerServiceApplication.class, args);
    }

}
