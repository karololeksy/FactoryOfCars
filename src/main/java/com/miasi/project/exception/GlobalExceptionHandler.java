package com.miasi.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WarehouseProblemException.class)
    public ResponseEntity<Object> handleWarehouseProblemException(WarehouseProblemException e) {
        return new ResponseEntity<>(new ExceptionBody(e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
