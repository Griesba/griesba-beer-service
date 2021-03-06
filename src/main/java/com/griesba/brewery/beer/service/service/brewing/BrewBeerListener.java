package com.griesba.brewery.beer.service.service.brewing;

import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.repository.BeerRepository;
import com.griesba.brewery.model.BeerOrderDto;
import com.griesba.brewery.model.events.BeerEvent;
import com.griesba.brewery.model.events.NewInventoryEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import static com.griesba.brewery.beer.service.config.JmsConfig.BREWING_REQUEST_QUEUE;
import static com.griesba.brewery.beer.service.config.JmsConfig.NEW_INVENTORY_QUEUE;

@Slf4j
@Service
@RequiredArgsConstructor
public class BrewBeerListener {

    private final JmsTemplate jmsTemplate;
    private final BeerRepository beerRepository;

    @JmsListener(destination = BREWING_REQUEST_QUEUE)
    public void listen(BeerEvent beerEvent) {
        if (beerEvent != null && beerEvent.getBeerDto() != null) {
            Beer beer = beerRepository.findById(beerEvent.getBeerDto().getId()).orElse(null);
            beerEvent.getBeerDto().setQuantityOnHand(beer != null ? beer.getQuantityToBrew() : null);

            log.info("Brewed beer {}: QOH {}", beer.getMinOnHand(), beer.getQuantityToBrew());
            NewInventoryEvent newInventoryEvent = new NewInventoryEvent();
            newInventoryEvent.setBeerDto(beerEvent.getBeerDto());
            jmsTemplate.convertAndSend(NEW_INVENTORY_QUEUE, newInventoryEvent);
        }
    }
}
