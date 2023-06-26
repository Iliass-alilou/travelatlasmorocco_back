package com.travelatlasmorocco.exceptions;

public class TourException extends RuntimeException {
    public TourException(String message){
        // supper : to initialize our constructor
        super(message);
    }
}
