package com.ing.weather.service.openweather;

import com.ing.weather.UnitTest;
import com.ing.weather.service.exceptions.CityNotFoundException;
import com.ing.weather.service.exceptions.OpenWeatherException;
import com.ing.weather.service.openweather.config.OpenWeatherHourlyConfig;
import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

class OpenWeatherHourlyServiceTest implements UnitTest {

    @Mock
    private OpenWeatherHourlyConfig config;

    @Mock
    private RestTemplate testRestTemplate;

    @InjectMocks
    private OpenWeatherHourlyService openWeatherHourlyService;


    @Test
    void getWeather_WithValidCity_ReturnsResponseEntity() {
        // Given
        String cityName = "London";
        HourlyServiceResponse responseBody = new HourlyServiceResponse();
        ResponseEntity<HourlyServiceResponse> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        when(config.getBaseUrl()).thenReturn("http://testapi.openweathermap.org/data/2.5/forecast");
        when(testRestTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(HourlyServiceResponse.class), anyMap()))
                .thenReturn(responseEntity);

        // When
        ResponseEntity<HourlyServiceResponse> result = openWeatherHourlyService.getWeather(cityName);

        // Then
        assertThat(result).isEqualTo(responseEntity);
    }

    @Test
    void getWeather_WithNotFoundCity_ThrowsCityNotFoundException() {
        // Given
        String cityName = "UnknownCity";
        when(config.getBaseUrl()).thenReturn("http://testapi.openweathermap.org/data/2.5/forecast");
        when(testRestTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(HourlyServiceResponse.class), anyMap()))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // When, Then
        assertThatThrownBy(() -> openWeatherHourlyService.getWeather(cityName))
                .isInstanceOf(CityNotFoundException.class)
                .hasMessageContaining(cityName);
    }

    @Test
    void getWeather_WithOtherHttpError_ThrowsOpenWeatherException() {
        // Given
        String cityName = "TestCity";
        when(config.getBaseUrl()).thenReturn("http://testapi.openweathermap.org/data/2.5/forecast");
        when(testRestTemplate.exchange(any(String.class), eq(HttpMethod.GET), any(HttpEntity.class), eq(HourlyServiceResponse.class), anyMap()))
                .thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

        // When, Then
        assertThatThrownBy(() -> openWeatherHourlyService.getWeather(cityName))
                .isInstanceOf(OpenWeatherException.class)
                .hasMessageContaining("Error Code: 500");
    }
}
