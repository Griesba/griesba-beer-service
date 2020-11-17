package com.griesba.brewery.beer.griesbabeerservice.service.inventory;

import java.time.OffsetDateTime;
import java.util.UUID;

public class BeerInventoryDtpBuilder {
    private UUID id;
    private UUID beerId;
    private OffsetDateTime creationDate;
    private OffsetDateTime lastModificationDate;
    private String upc;
    private int quantityOnHand;

    public BeerInventoryDtpBuilder setId(UUID id) {
        this.id = id;
        return this;
    }

    public BeerInventoryDtpBuilder setBeerId(UUID beerId) {
        this.beerId = beerId;
        return this;
    }

    public BeerInventoryDtpBuilder setCreationDate(OffsetDateTime creationDate) {
        this.creationDate = creationDate;
        return this;
    }

    public BeerInventoryDtpBuilder setLastModificationDate(OffsetDateTime lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
        return this;
    }

    public BeerInventoryDtpBuilder setUpc(String upc) {
        this.upc = upc;
        return this;
    }

    public BeerInventoryDtpBuilder setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
        return this;
    }

    public BeerInventoryDto createBeerInventoryDtp() {
        return new BeerInventoryDto(id, beerId, creationDate, lastModificationDate, upc, quantityOnHand);
    }
}
