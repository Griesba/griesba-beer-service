package com.griesba.brewery.beer.service.service.inventory;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
public class BeerInventoryDto {
    private UUID id;
    private UUID beerId;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastModificationDate;
    private String upc;
    private int quantityOnHand;

    public BeerInventoryDto(UUID id, UUID beerId, OffsetDateTime creationDate, OffsetDateTime lastModificationDate, String upc, int quantityOnHand) {
        this.id = id;
        this.beerId = beerId;
        this.creationDate = creationDate;
        this.lastModificationDate = lastModificationDate;
        this.upc = upc;
        this.quantityOnHand = quantityOnHand;
    }
}
