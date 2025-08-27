package com.mcsv.hotel.hotel_service.reopository;

import com.mcsv.hotel.hotel_service.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity,String>{ }
