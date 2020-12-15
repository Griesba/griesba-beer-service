package com.griesba.brewery.beer.service.web;

import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.service.inventory.InventoryClient;
import com.griesba.brewery.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator  implements BeerMapper{
    private BeerMapper beerMapper;
    private InventoryClient inventoryClient;

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }

    @Autowired
    public void setInventoryClient(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto beerDto = beerMapper.beerToBeerDtoWithInventory(beer);
        beerDto.setQuantityOnHand(inventoryClient.listBeerInventory(beer.getId()));
        return beerDto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return beerMapper.beerDtoToBeer(beerDto);
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return beerMapper.beerToBeerDto(beer);
    }
}