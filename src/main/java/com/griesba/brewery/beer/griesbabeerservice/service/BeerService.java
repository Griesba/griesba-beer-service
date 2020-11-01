package com.griesba.brewery.beer.griesbabeerservice.service;

import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;

public interface BeerService {

    BeerDto getById(String id);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(BeerDto beerDto);

}
