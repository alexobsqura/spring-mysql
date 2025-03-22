package com.obsqura.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException e) {
        ExceptionDetail exceptionDetail = new ExceptionDetail(LocalDateTime.now(), "Product Not Found", e.getMessage());
        return new ResponseEntity<>(exceptionDetail, HttpStatus.NOT_FOUND);
    }
}
