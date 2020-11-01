package com.griesba.brewery.beer.griesbabeerservice.repository;

import com.griesba.brewery.beer.griesbabeerservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BeerRepository extends PagingAndSortingRepository<Beer, String> {
}
