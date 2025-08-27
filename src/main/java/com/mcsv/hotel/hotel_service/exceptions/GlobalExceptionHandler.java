package com.mcsv.hotel.hotel_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleResourceNotFoundException(ResourceNotFoundException e) {

        Map<String, Object> body = Map.of(  //uso map.of en vez de agregar con map.put.
                 "message", e.getMessage(),
                "success", false,
                "status", HttpStatus.NOT_FOUND
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    //valida las exceptions que se lanzan en @Valid
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException e) {

        Map<String, String> errores = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }


        // Map principal de respuesta
        Map<String, Object> body = Map.of(
                "message", "Errores de validación",
                "success", false,
                "status", HttpStatus.BAD_REQUEST,
                "errors", errores
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

}
