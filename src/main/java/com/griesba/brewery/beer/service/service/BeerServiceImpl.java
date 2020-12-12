package com.griesba.brewery.beer.service.service;

import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.repository.BeerRepository;
import com.griesba.brewery.beer.service.web.BeerDto;
import com.griesba.brewery.beer.service.web.BeerMapper;
import com.griesba.brewery.model.BeerPagedList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    @Cacheable(cacheNames = "beerCache", key = "#id", condition = "#showInventoryOnHand = true ")
    @Override
    public BeerDto getById(UUID id, boolean showInventoryOnHand) {
        log.info("### Find beer by id request");
        Beer beer = beerRepository.findById(id).orElseThrow();
        return showInventoryOnHand ? beerMapper.beerToBeerDtoWithInventory(beer) : beerMapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDto saveBeer(BeerDto beerDto) {
        return beerMapper.beerToBeerDtoWithInventory(
                beerRepository.save(
                        beerMapper.beerDtoToBeer(beerDto)
                )
        );
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElse(null);
        if (beer != null) {
            beer.setName(beerDto.getName());
            beer.setMinOnHand(beerDto.getMinOnHand());
            beer.setPrice(beerDto.getPrice());
            beer.setQuantityToBrew(beerDto.getQuantityToBrew());
            beer.setUpc(beerDto.getUpc());
            return beerMapper.beerToBeerDtoWithInventory(beerRepository.save(beer));
        } else {
            return beerMapper.beerToBeerDtoWithInventory(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
        }
    }

    @Cacheable(cacheNames = "beerListCache", condition = "#showInventoryOnHand = true")
    @Override
    public BeerPagedList find(int pageNumber, int pageSize, boolean showInventoryOnHand) {
        log.info("### Find beers request");
        Page<Beer> beerPage = beerRepository.findAll(PageRequest.of(pageNumber, pageSize));

         return showInventoryOnHand ?
                 new BeerPagedList(
                         beerPage.getContent().stream().map(beerMapper::beerToBeerDtoWithInventory).collect(Collectors.toList()),
                         PageRequest.of(beerPage.getPageable().getPageNumber(), beerPage.getPageable().getPageSize()),
                         beerPage.getTotalElements())
                 : new BeerPagedList(
                         beerPage.getContent().stream().map(beerMapper::beerToBeerDto).collect(Collectors.toList()),
                         PageRequest.of(beerPage.getPageable().getPageNumber(), beerPage.getPageable().getPageSize()),
                         beerPage.getTotalElements());

    }

    @Cacheable(cacheNames = "beerUpcCache", key = "#upc")
    @Override
    public BeerDto getByUpc(String upc) {
        log.info("### Find beer by upc request {}", upc);
        Beer beer = beerRepository.findByUpc(upc);
        return beer != null ? beerMapper.beerToBeerDto(beer) : null;
    }
}
