package com.griesba.brewery.beer.service.service.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class InventoryServiceFeignFailoverClient implements InventoryServiceFeign{

    private final InventoryFailoverFeign failoverFeignClient;

    @Override
    public ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(UUID beerId) {
        return failoverFeignClient.getOnHandInventory();
    }
}
