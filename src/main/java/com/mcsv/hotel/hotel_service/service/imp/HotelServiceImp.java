package com.mcsv.hotel.hotel_service.service.imp;


import com.mcsv.hotel.hotel_service.Mapper.HotelMapper;
import com.mcsv.hotel.hotel_service.entity.HotelEntity;
import com.mcsv.hotel.hotel_service.exceptions.ResourceNotFoundException;
import com.mcsv.hotel.hotel_service.reopository.HotelRepository;
import com.mcsv.hotel.hotel_service.response.HotelDtoRequest;
import com.mcsv.hotel.hotel_service.response.HotelDtoResponse;
import com.mcsv.hotel.hotel_service.service.HotelService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HotelServiceImp implements HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelServiceImp(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public HotelDtoResponse saveHotel(HotelDtoRequest hotelDtoRequest) {

        HotelEntity hotel = hotelMapper.hotelDtoToHotelEntity(hotelDtoRequest);
        return hotelMapper.hotelEntityToHotelDto(hotel);
    }

    @Override
    public HotelDtoResponse getHotel(String hotelId) {
        HotelEntity hotel = hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("Hotel con ID: "+hotelId+" no encontrado"));
        return hotelMapper.hotelEntityToHotelDto(hotel);
    }

    @Override
    public List<HotelDtoResponse> getAllHotels() {
       return hotelRepository.findAll()
               .stream()
               .map(hotelMapper::hotelEntityToHotelDto)
               .toList();
    }
}