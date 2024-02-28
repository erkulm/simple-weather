package com.ing.weather.service.exposed;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ing.weather.service.exceptions.CityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JsonProcessingException.class)
    public ResponseEntity<Object> handleJsonProcessingException(
            JsonProcessingException ex) {
        return internalError("Internal Server error: " + ex.getMessage());
    }

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<Object> handleCityNotFoundException(
            CityNotFoundException ex) {
        return notFound(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(
            Exception ex) {
        log.error(ExceptionUtils.getStackTrace(ex));
        return badRequest("Error: " + ex.getMessage());
    }

    private ResponseEntity<Object> notFound(String message) {
        Map<String, Object> body = body(message);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<Object> badRequest(String message) {
        Map<String, Object> body = body(message);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<Object> internalError(String message) {
        Map<String, Object> body = body(message);
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private static Map<String, Object> body(String message) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", message);

        log.error(body.toString());
        return body;
    }
}
