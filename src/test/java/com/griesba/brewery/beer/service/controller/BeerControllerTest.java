package com.griesba.brewery.beer.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.griesba.brewery.beer.service.service.BeerService;
import com.griesba.brewery.beer.service.web.BeerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {
private static String BASE_URL = "/api/v1/beer";
    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerService;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void shouldTestGetBeerById() throws Exception {
        BDDMockito.given(beerService.getById(any(), anyBoolean())).willReturn(buildBeerDto());

        mockMvc.perform(MockMvcRequestBuilders.get(BASE_URL + "/" + UUID.randomUUID())
                .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void shouldCreateBeer() throws Exception {
        BeerDto beerDto = buildBeerDto();

        BDDMockito.given(beerService.saveBeer(any())).willReturn(beerDto);

        mockMvc.perform(post(BASE_URL)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(beerDto))
        ).andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateBeer() throws Exception {
        BeerDto beerDto = buildBeerDto();

        BDDMockito.given(beerService.updateBeer(any(), any())).willReturn(beerDto);

        mockMvc.perform(put(BASE_URL + "/" + UUID.randomUUID())
                    .accept(MediaType.APPLICATION_JSON)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(beerDto)))
                .andExpect(status().isNoContent());
    }

    public BeerDto buildBeerDto() {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .upc("12345666")
                .name("Corona")
                .style("Blond")
                .price(2.4d)
                .build();
    }
}
