package com.griesba.brewery.beer.griesbabeerservice.controller;

import com.griesba.brewery.beer.griesbabeerservice.service.BeerService;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import com.griesba.brewery.model.BeerPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerService beerService;

    @GetMapping("/{beerId}")
    public BeerDto getBeer(@PathVariable String beerId) {
        return beerService.getById(beerId);
    }

    @GetMapping(produces = {"application/json"})
    public BeerPagedList getBeers(@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
                                  @DefaultValue("10")
                                  @PathParam(value = "pageSize") Integer pageSize){
        if (pageSize == null) {
            pageSize = 10;
        }
        return beerService.find(pageNumber, pageSize);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BeerDto create(@RequestBody BeerDto beerDto) {
        return beerService.saveBeer(beerDto);
    }

}
