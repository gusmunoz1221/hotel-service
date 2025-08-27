package com.mcsv.hotel.hotel_service.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException() {
        super("Recurso no encontrado!!!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
