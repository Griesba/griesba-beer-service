package com.griesba.brewery.beer.service.bootstrap;

import com.griesba.brewery.beer.service.domain.Beer;
import com.griesba.brewery.beer.service.domain.BeerStyleEnum;
import com.griesba.brewery.beer.service.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;

import java.math.BigDecimal;

@RequiredArgsConstructor
//@Component
public class Bootstrap implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {

        if (beerRepository.count() != 0) { return;}

        Beer b1 = Beer.builder()
                .name("Mango Bobs")
                .style(BeerStyleEnum.IPA.name())
                .minOnHand(12)
                .quantityToBrew(200)
                .price(12.95)
                .upc(BEER_1_UPC)
                .build();

        Beer b2 = Beer.builder()
                .name("Galaxy Cat")
                .style(BeerStyleEnum.PALE_ALE.name())
                .minOnHand(12)
                .quantityToBrew(200)
                .price(new BigDecimal("12.95").doubleValue())
                .upc(BEER_2_UPC)
                .build();

        Beer b3 = Beer.builder()
                .name("Pinball Porter")
                .style(BeerStyleEnum.PALE_ALE.name())
                .minOnHand(12)
                .quantityToBrew(200)
                .price(new BigDecimal("12.95").doubleValue())
                .upc(BEER_3_UPC)
                .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}
