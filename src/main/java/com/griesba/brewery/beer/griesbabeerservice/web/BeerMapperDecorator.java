package com.griesba.brewery.beer.griesbabeerservice.web;

import com.griesba.brewery.beer.griesbabeerservice.domain.Beer;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BeerMapperDecorator  implements BeerMapper{
    private BeerMapper beerMapper;

    @Autowired
    public void setBeerMapper(BeerMapper beerMapper) {
        this.beerMapper = beerMapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return beerMapper.beerToBeerDto(beer);
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return beerMapper.beerDtoToBeer(beerDto);
    }
}
