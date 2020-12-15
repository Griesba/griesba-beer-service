package com.griesba.brewery.beer.service.service.brewing;


import com.griesba.brewery.beer.service.config.JmsConfig;
import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.repository.BeerRepository;
import com.griesba.brewery.beer.service.service.inventory.InventoryClient;
import com.griesba.brewery.beer.service.web.BeerMapper;
import com.griesba.brewery.model.events.BrewBeerEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class BrewingService {
    private final InventoryClient inventoryClient;
    private final BeerRepository beerRepository;
    private final JmsTemplate jmsTemplate;
    private final BeerMapper beerMapper;

    @Scheduled(fixedRate = 10000)// each minute
    public void checkForLowInventory() {
        List<Beer> beerList = StreamSupport.stream(beerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        beerList.forEach(beer -> {
            Integer inventoryQuantityOnHand = inventoryClient.listBeerInventory(beer.getId());

            if (inventoryQuantityOnHand <= beer.getMinOnHand()) {

                jmsTemplate.convertAndSend(JmsConfig.BREWING_REQUEST_QUEUE,
                        new BrewBeerEvent.BrewBeerEventBuilder()
                                .withBeerDto(beerMapper.beerToBeerDto(beer))
                                .build());
            }
        });
    }
}
