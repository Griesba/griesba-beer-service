package com.griesba.brewery.beer.griesbabeerservice.service;

import com.griesba.brewery.beer.griesbabeerservice.domain.Beer;
import com.griesba.brewery.beer.griesbabeerservice.repository.BeerRepository;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerDto;
import com.griesba.brewery.beer.griesbabeerservice.web.BeerMapper;
import com.griesba.brewery.model.BeerPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

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
        Beer beer = beerRepository.findById(beerDto.getId().toString()).orElse(null);
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

    @Override
    public BeerPagedList find(int pageNumber, int pageSize) {
         Page<Beer> beerPage = beerRepository.findAll(PageRequest.of(pageNumber, pageSize));

         return new BeerPagedList(
                 beerPage.getContent().stream().map(beerMapper::beerToBeerDto).collect(Collectors.toList()),
                 PageRequest.of(beerPage.getPageable().getPageNumber(), beerPage.getPageable().getPageSize()),
                 beerPage.getTotalElements());

    }
}
