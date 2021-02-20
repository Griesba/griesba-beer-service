package com.griesba.brewery.beer.service.service.inventory;

import com.griesba.brewery.beer.service.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.UUID;

@Profile("local-discovery")
@FeignClient(name = "inventory-service", fallback = InventoryServiceFeignFailoverClient.class, configuration = FeignClientConfig.class)
public interface InventoryServiceFeign {
    @RequestMapping(method = RequestMethod.GET, value = InventoryRestTemplateClient.INVENTORY_PATH)
    ResponseEntity<List<BeerInventoryDto>> getOnHandInventory(@PathVariable UUID beerId);
}
