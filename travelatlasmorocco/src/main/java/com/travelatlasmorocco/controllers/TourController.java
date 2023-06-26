package com.travelatlasmorocco.controllers;

import java.util.ArrayList;
import java.util.List;

import com.travelatlasmorocco.exceptions.TourException;
import com.travelatlasmorocco.requests.TourRequest;
import com.travelatlasmorocco.responses.ErrorMessages;
import com.travelatlasmorocco.services.TourService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;

import com.travelatlasmorocco.responses.TourResponse;
import com.travelatlasmorocco.shared.dto.TourDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tours")
public class TourController {
    @Autowired
    TourService tourService ;
    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<TourResponse>> getAllTours () {
        List<TourResponse> tourResponses = new ArrayList<>();
        List<TourDto> tours =tourService.getAllTours();
        for (TourDto tourDto : tours) {
            ModelMapper modelMapper = new ModelMapper();
            TourResponse tour = modelMapper.map(tourDto, TourResponse.class);
            tourResponses.add(tour);
        }
        return new ResponseEntity<List<TourResponse>>(tourResponses,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TourResponse> createTour(@RequestBody TourRequest tourRequest) throws Exception{
        if(tourRequest.getNom().isEmpty() || tourRequest.getDescription().isEmpty()){
            throw new TourException(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
        }
        ModelMapper modelMapper = new ModelMapper();
        TourDto tourDto = modelMapper.map(tourRequest, TourDto.class);
        TourDto createTour = tourService.createTour(tourDto);
        TourResponse tourResponse = modelMapper.map(createTour,TourResponse.class);
        return new ResponseEntity<TourResponse>(tourResponse,HttpStatus.CREATED);
    }
}
