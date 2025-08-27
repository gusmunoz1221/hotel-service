package com.mcsv.hotel.hotel_service.Mapper;

import com.mcsv.hotel.hotel_service.entity.HotelEntity;
import com.mcsv.hotel.hotel_service.response.HotelDtoRequest;
import com.mcsv.hotel.hotel_service.response.HotelDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {

    public HotelEntity hotelDtoToHotelEntity(HotelDtoRequest hotelDtoRequest){
        return HotelEntity.builder()
                .name(hotelDtoRequest.getName())
                .ubication(hotelDtoRequest.getUbication())
                .information(hotelDtoRequest.getInformation())
                .build();
    }
    public HotelDtoResponse hotelEntityToHotelDto(HotelEntity hotelEntity){
        return HotelDtoResponse.builder()
                .name(hotelEntity.getName())
                .ubication(hotelEntity.getUbication())
                .information(hotelEntity.getInformation())
                .build();
    }
}
