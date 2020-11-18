package com.griesba.brewery.beer.griesbabeerservice.controller;

import com.griesba.brewery.beer.griesbabeerservice.service.BeerService;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import com.griesba.brewery.model.BeerPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public BeerDto getBeer(@PathVariable UUID beerId,
                           @RequestParam(value = "showInventoryOnHand", required = false, defaultValue = "false") boolean showIOH) {
        return beerService.getById(beerId, showIOH);
    }

    @GetMapping(produces = {"application/json"})
    public BeerPagedList getBeers(@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                                  @DefaultValue("10")
                                  @RequestParam(value = "pageSize") Integer pageSize,
                                  @RequestParam(value = "showInventoryOnHand", required = false, defaultValue = "false") boolean showIOH){
        if (pageSize == null) {
            pageSize = 10;
        }
        return beerService.find(pageNumber, pageSize, showIOH);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDto create(@RequestBody BeerDto beerDto) {
        return beerService.saveBeer(beerDto);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity update(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        return new ResponseEntity(beerService.updateBeer(beerId, beerDto), HttpStatus.NO_CONTENT);
    }

}
