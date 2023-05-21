package me.dio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import me.dio.service.exception.BusinessException;
import me.dio.service.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handleBusinessException(BusinessException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNoContentException() {
        return new ResponseEntity<>("Resource ID not found.", HttpStatus.NOT_FOUND);
    }
}

