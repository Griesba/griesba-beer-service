package com.griesba.brewery.beer.griesbabeerservice.service;

import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import com.griesba.brewery.model.BeerPagedList;

import java.util.List;

public interface BeerService {

    BeerDto getById(String id);

    BeerDto saveBeer(BeerDto beerDto);

    BeerDto updateBeer(BeerDto beerDto);

    BeerPagedList find(int pageNumber, int pageSize);
}
