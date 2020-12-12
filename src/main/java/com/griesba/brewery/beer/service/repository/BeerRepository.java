package com.griesba.brewery.beer.service.repository;

import com.griesba.brewery.beer.service.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {

    Beer findByUpc(String upc);
}
