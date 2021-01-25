package com.griesba.brewery.beer.service.service.inventory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Profile("local-discovery")
@Slf4j
@RequiredArgsConstructor
@Service
public class InventoryServiceFeignClient implements InventoryService {
    private final InventoryServiceFeign inventoryServiceFeign;

    @Override
    public Integer getOnHandInventory(UUID beerId) {
        log.debug("Calling inventory service - beerId: " + beerId);

        ResponseEntity<List<BeerInventoryDto>> responseEntity = inventoryServiceFeign.getOnHandInventory(beerId);

        Integer onHand = Objects.requireNonNull(responseEntity.getBody())
                .stream().mapToInt(BeerInventoryDto::getQuantityOnHand)
                .sum();

        log.debug("BeerId: " + beerId + " On hand is: " + onHand);

        return onHand;
    }
}
