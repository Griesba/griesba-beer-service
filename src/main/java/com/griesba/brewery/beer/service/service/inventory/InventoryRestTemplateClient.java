package com.griesba.brewery.beer.service.service.inventory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Profile("!local-discovery")
@Slf4j
@Component
@ConfigurationProperties(prefix = "griesba.brewery", ignoreInvalidFields = false)
public class InventoryRestTemplateClient implements InventoryService{

    static final String INVENTORY_PATH = "/api/v1/beer/{beerId}/inventory";

    private RestTemplate restTemplate;

    private String beerInventoryServiceHost;

    public void setBeerInventoryServiceHost(String beerInventoryServiceHost) {
        this.beerInventoryServiceHost = beerInventoryServiceHost;
    }

    @Autowired
    public InventoryRestTemplateClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Integer getOnHandInventory(UUID beerId) {
        String url = beerInventoryServiceHost + INVENTORY_PATH;
        log.info("calling beer inventory service quantityOnHand for beerId {}", beerId);
        ResponseEntity<List<BeerInventoryDto>> responseEntity =  restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BeerInventoryDto>>(){},
                beerId);

        return  Objects.requireNonNull(responseEntity.getBody())
                .stream().mapToInt(BeerInventoryDto::getQuantityOnHand).sum();

    }

}
