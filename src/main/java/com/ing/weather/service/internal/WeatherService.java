package com.ing.weather.service.internal;

import com.ing.weather.service.openweather.OpenWeatherHourlyService;
import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final OpenWeatherHourlyService openWeatherService;
    private final OpenWeatherMapper mapper;

    @Cacheable(value = "forecasts", key = "#cityName")
    public TwoDaysForecast get48HourForecastByCityName(String cityName) {
        ResponseEntity<HourlyServiceResponse> forecast = openWeatherService.getWeather(cityName);
        if (forecast.getStatusCode().is2xxSuccessful()) {
            return mapper.map(Objects.requireNonNull(forecast.getBody()));
        }
        return null;
    }

}
