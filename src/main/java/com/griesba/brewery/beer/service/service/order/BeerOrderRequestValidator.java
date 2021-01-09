package com.griesba.brewery.beer.service.service.order;

import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.repository.BeerRepository;
import com.griesba.brewery.model.BeerOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@RequiredArgsConstructor
@Component
public class BeerOrderRequestValidator {

    private final BeerRepository beerRepository;

    boolean validate(BeerOrderDto beerOrderDto) {

        AtomicInteger atomicInteger = new AtomicInteger();

        beerOrderDto.getBeerOrderLines().forEach(beerOrderLineDto -> {
           if (beerRepository.findByUpc(beerOrderLineDto.getUpc()) == null) {
               atomicInteger.incrementAndGet();
           }
        });

        return atomicInteger.get() == 0;
    }
}
