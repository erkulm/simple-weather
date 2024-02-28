package com.ing.weather.service.openweather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ing.weather.IntegrationTest;
import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class OpenWeatherHourlyServiceIT implements IntegrationTest {
    @Autowired
    OpenWeatherHourlyService openWeatherHourlyService;

    @Test
    void getWeather() throws JsonProcessingException {
        ResponseEntity<HourlyServiceResponse> istanbul = openWeatherHourlyService.getWeather("istanbul");

        System.out.println(istanbul.getBody());
        assertThat(istanbul.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}