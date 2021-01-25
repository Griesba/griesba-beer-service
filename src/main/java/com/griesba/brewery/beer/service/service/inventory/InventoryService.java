package com.griesba.brewery.beer.service.service.inventory;

import java.util.UUID;

public interface InventoryService {
    Integer getOnHandInventory(UUID beerId);
}
