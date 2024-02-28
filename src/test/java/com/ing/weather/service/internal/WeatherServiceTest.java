package com.ing.weather.service.internal;

import com.ing.weather.service.openweather.OpenWeatherHourlyService;
import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    @Mock
    private OpenWeatherHourlyService openWeatherHourlyService;

    @Mock
    private OpenWeatherMapper openWeatherMapper;

    private WeatherService weatherService;

    @BeforeEach
    void setUp() {
        weatherService = new WeatherService(openWeatherHourlyService, openWeatherMapper);
    }

    @Test
    void get48HourForecastByCityName_WhenWeatherServiceReturnsSuccess_ReturnsForecast() {
        // Given
        String cityName = "TestCity";
        HourlyServiceResponse serviceResponse = new HourlyServiceResponse();
        ResponseEntity<HourlyServiceResponse> responseEntity = new ResponseEntity<>(serviceResponse, HttpStatus.OK);
        when(openWeatherHourlyService.getWeather(anyString())).thenReturn(responseEntity);
        when(openWeatherMapper.map(any())).thenReturn(new TwoDaysForecast());
        TwoDaysForecast expectedForecast = new TwoDaysForecast();

        // When
        TwoDaysForecast actualForecast = weatherService.get48HourForecastByCityName(cityName);

        // Then
        assertThat(actualForecast).isEqualTo(expectedForecast);
        verify(openWeatherMapper).map(serviceResponse);
    }


    @Test
    void get48HourForecastByCityName_WhenWeatherServiceReturnsFailure_ReturnsNull() {
        // Given
        String cityName = "TestCity";
        ResponseEntity<HourlyServiceResponse> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        when(openWeatherHourlyService.getWeather(anyString())).thenReturn(responseEntity);

        // When
        TwoDaysForecast actualForecast = weatherService.get48HourForecastByCityName(cityName);

        // Then
        assertThat(actualForecast).isNull();
        verifyNoInteractions(openWeatherMapper);
    }
}
