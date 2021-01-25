package com.griesba.brewery.beer.service.web;

import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.service.inventory.InventoryRestTemplateClient;
import com.griesba.brewery.beer.service.service.inventory.InventoryService;
import com.griesba.brewery.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator  implements BeerMapper{
    private BeerMapper beerMapper;
    private InventoryService inventoryClient;

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }

    @Autowired
    public void setInventoryClient(InventoryService inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto beerDto = beerMapper.beerToBeerDtoWithInventory(beer);
        beerDto.setQuantityOnHand(inventoryClient.getOnHandInventory(beer.getId()));
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
