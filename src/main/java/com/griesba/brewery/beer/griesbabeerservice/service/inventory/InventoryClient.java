package com.griesba.brewery.beer.griesbabeerservice.service.inventory;

import ch.qos.logback.classic.spi.TurboFilterList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Service
@ConfigurationProperties(prefix = "griesba.brewery", ignoreInvalidFields = false)
public class InventoryClient  {

    private RestTemplate inventoryClient;

    private String beerInventoryServiceHost;

    public void setBeerInventoryServiceHost(String beerInventoryServiceHost) {
        this.beerInventoryServiceHost = beerInventoryServiceHost;
    }

    @Autowired
    public InventoryClient(RestTemplateBuilder restTemplateBuilder) {
        this.inventoryClient = restTemplateBuilder.build();
    }

    public Integer listBeerInventory(UUID beerId) {
        String url = beerInventoryServiceHost + "/api/v1/beer/{beerId}/inventory";
        ResponseEntity<List<BeerInventoryDto>> responseEntity =  inventoryClient.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BeerInventoryDto>>(){},
                (Object)beerId);

        return  Objects.requireNonNull(responseEntity.getBody())
                .stream().mapToInt(BeerInventoryDto::getQuantityOnHand).sum();

    }

}
