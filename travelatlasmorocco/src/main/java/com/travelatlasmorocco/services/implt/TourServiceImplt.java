package com.travelatlasmorocco.services.implt;

import com.travelatlasmorocco.entities.ItineraireEntity;
import com.travelatlasmorocco.entities.TourEntity;
import com.travelatlasmorocco.repositories.TourRepository;
import com.travelatlasmorocco.services.TourService;
import com.travelatlasmorocco.shared.Utils;
import com.travelatlasmorocco.shared.dto.ItineraireDto;
import com.travelatlasmorocco.shared.dto.TourDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class TourServiceImplt implements TourService {

    @Autowired
    TourRepository tourRepository;
    @Autowired
    Utils util;
    @Override
    public List<TourDto> getAllTours() {
        List<TourEntity> tours = tourRepository.findAll();
        Type listType = new TypeToken<List<TourDto>>() {}.getType();
        List<TourDto> tourDto = new  ModelMapper().map(tours, listType);
        return tourDto;
    }

    @Override
    public TourDto createTour(TourDto tourDto) {
        // check exiting tour
        TourEntity checkExisting_tour = tourRepository.findByNom(tourDto.getNom());
        if(checkExisting_tour != null){
            throw new RuntimeException("tour already exist !");
        }
        for(int i = 0; i < tourDto.getItineraire().size() ; i++){
            ItineraireDto itineraire = tourDto.getItineraire().get(i);
            itineraire.setTour(tourDto);
            itineraire.setIteneraireId(util.generatedValue(30));
            tourDto.getItineraire().set(i,itineraire);
        }
        ModelMapper modelMapper = new ModelMapper();
        TourEntity tourEntity = modelMapper.map(tourDto,TourEntity.class);
        tourEntity.setTourId(util.generatedValue(30));

        TourEntity newTour = tourRepository.save(tourEntity);

        TourDto tourDtoCreated = modelMapper.map(newTour,TourDto.class);

        return tourDtoCreated;
    }
}
