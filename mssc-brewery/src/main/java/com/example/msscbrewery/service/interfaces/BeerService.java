package com.example.msscbrewery.service.interfaces;

import com.example.msscbrewery.model.BeerDTO;

import java.util.UUID;

public interface BeerService {
    BeerDTO getBeerId(UUID beerId);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerId, BeerDTO beerDTO);

    void deletebyId(UUID beerId);
}
