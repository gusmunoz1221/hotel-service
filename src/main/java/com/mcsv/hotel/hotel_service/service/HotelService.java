package com.mcsv.hotel.hotel_service.service;

import com.mcsv.hotel.hotel_service.response.HotelDtoRequest;
import com.mcsv.hotel.hotel_service.response.HotelDtoResponse;

import java.util.List;

public interface HotelService {
    HotelDtoResponse saveHotel(HotelDtoRequest hotelDtoRequest);
    HotelDtoResponse getHotel(String hotelId);
    List<HotelDtoResponse> getAllHotels();
}
