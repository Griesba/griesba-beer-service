package com.griesba.brewery.beer.griesbabeerservice.web;

import com.griesba.brewery.beer.griesbabeerservice.domain.Beer;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto beerDto);
}
