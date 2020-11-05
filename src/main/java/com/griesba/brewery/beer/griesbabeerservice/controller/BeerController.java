package com.griesba.brewery.beer.griesbabeerservice.controller;

import com.griesba.brewery.beer.griesbabeerservice.service.BeerService;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/beer/{beerId}")
    public BeerDto getBeer(@PathVariable String beerId) {
        return beerService.getById(beerId);
    }

    @PostMapping("/beer")
    public BeerDto create(@RequestBody BeerDto beerDto) {
        return beerService.saveBeer(beerDto);
    }

}
