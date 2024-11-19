package com.examenparcial.examenparcial.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class GlobalException {
    private static final Logger log = LoggerFactory.getLogger(GlobalException.class);

    // Manejo de excepciones específicas (IllegalArgumentException)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex, WebRequest request) {
        log.error("IllegalArgumentException occurred: ", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body("Error: " + ex.getMessage());
    }

    // Manejo de excepciones genéricas (Exception)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGlobalException(Exception ex, WebRequest request) {
        log.error("Unexpected error occurred: ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body("Ocurrió un error inesperado: " + ex.getMessage());
    }

    // Manejo de excepciones personalizadas (CustomException)
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleCustomException(CustomException ex, WebRequest request) {
        log.error("CustomException occurred: ", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                             .body("Error: " + ex.getMessage());
    }
}