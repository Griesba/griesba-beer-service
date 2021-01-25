package com.griesba.brewery.beer.service.service.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "inventory-service", fallback = InventoryServiceFeignFailoverClient.class)
public interface InventoryServiceFeign {
    @RequestMapping(method = RequestMethod.GET, value = InventoryRestTemplateClient.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(@PathVariable UUID beerId);
}
