package com.mcsv.hotel.hotel_service.controller;

import com.mcsv.hotel.hotel_service.response.HotelDtoRequest;
import com.mcsv.hotel.hotel_service.response.HotelDtoResponse;
import com.mcsv.hotel.hotel_service.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private final HotelService hotelService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public ResponseEntity<HotelDtoResponse> saveHotel(@Valid @Validated @RequestBody HotelDtoRequest hotelDtoRequest){
        HotelDtoResponse hotel = hotelService.saveHotel(hotelDtoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @GetMapping("/id")
    public ResponseEntity<HotelDtoResponse> getHotel(@PathVariable String hotelId){
        HotelDtoResponse hotel = hotelService.getHotel(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping
    public ResponseEntity<List<HotelDtoResponse>> getHotel(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

}
