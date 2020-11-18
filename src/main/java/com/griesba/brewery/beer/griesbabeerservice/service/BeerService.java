package com.griesba.brewery.beer.griesbabeerservice.service;

import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import com.griesba.brewery.model.BeerPagedList;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID id, boolean showIOH);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList find(int pageNumber, int pageSize, boolean showInventoryOnHand);
}
