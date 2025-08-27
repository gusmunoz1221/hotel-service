package com.mcsv.hotel.hotel_service.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDtoResponse {
    private String name;
    private String ubication;
    private String information;
}
