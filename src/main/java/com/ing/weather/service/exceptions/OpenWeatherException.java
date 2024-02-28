package com.ing.weather.service.exceptions;

public class OpenWeatherException extends RuntimeException {
    public OpenWeatherException(String message) {
        super(message);
    }
}
