package com.mcsv.hotel.hotel_service.response;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelDtoRequest {
    @NotBlank(message = "Debe agregar un nombre")
    @Size(max = 20, message = "El nombre no puede tener mas de 20 caracteres")
    private String name;

    @NotBlank(message = "Debe agregar la ubicacion")
    @Size(max = 100, message = "la information debe ser menor a 100 caracteres")
    @Size(min = 15, message = "Debe agregar mas informacion de la ubicacion")
    private String ubication;

    @NotBlank(message = "Debe agregar la informacion")
    @Size(max = 100, message = "la informacion debe ser menor a 100 caracteres")
    @Size(min = 15, message = "Debe agregar mas informacion")
    private String information;
}

