package com.griesba.brewery.beer.griesbabeerservice.controller;

import com.griesba.brewery.beer.griesbabeerservice.service.BeerService;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/beer")
public class BeerController {

    private BeerService beerService;

    @GetMapping("{beerId}")
    public BeerDto getBeer(String beerId) {
        return beerService.getById(beerId);
    }

}
