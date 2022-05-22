package com.excentricdevs.presp.feign.exceptions;

import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class FeignExceptionHandler {

    @ExceptionHandler(value = {FeignException.class})
    public ResponseEntity<StandardError> feignException(FeignException exception, HttpServletResponse response) {
        StandardError error = new StandardError(System.currentTimeMillis(), exception.status(), "Feign exception!");
        return ResponseEntity.status(exception.status()).body(error);
    }
}
