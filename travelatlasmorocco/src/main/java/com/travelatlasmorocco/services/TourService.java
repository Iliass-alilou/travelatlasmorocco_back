package com.travelatlasmorocco.services;

import com.travelatlasmorocco.shared.dto.TourDto;

import java.util.List;

public interface TourService {
    List<TourDto> getAllTours();
    TourDto createTour(TourDto tourDto);
}
