package com.griesba.brewery.beer.griesbabeerservice.service;

import com.griesba.brewery.beer.griesbabeerservice.domain.Beer;
import com.griesba.brewery.beer.griesbabeerservice.repository.BeerRepository;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerMapper;
import org.springframework.stereotype.Service;

@Service
public class BeerServiceImpl implements BeerService {

    private BeerRepository beerRepository;
    private BeerMapper beerMapper;

    @Override
    public BeerDto getById(String id) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(id).orElseThrow()
        );
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDto(
                beerRepository.save(
                        beerMapper.beerDtoToBeer(beerDto)
                )
        );
    }

    @Override
    public BeerDto updateBeer(BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerDto.getId()).orElse(null);
        if (beer != null) {
            beer.setName(beerDto.getName());
            beer.setMinOnHand(beerDto.getMinOnHand());
            beer.setPrice(beerDto.getPrice());
            beer.setQuantityToBrew(beerDto.getQuantityToBrew());
            beer.setUpc(beerDto.getUpc());
            return beerMapper.beerToBeerDto(beerRepository.save(beer));
        } else {
            return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
        }
    }
}