package com.ing.weather.service.exposed;

import com.ing.weather.service.internal.TwoDaysForecast;
import com.ing.weather.service.internal.WeatherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "two-days")
@RequiredArgsConstructor
@Slf4j
public class TwoDaysForecastRestController implements TwoDaysForecastAPI {

    private final WeatherService weatherService;

    @GetMapping(value = "/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TwoDaysForecast> getForecast(@PathVariable(name = "cityName") String cityName) {
        log.info("Simple weather api is called for: {}", cityName);
        return new ResponseEntity<>(weatherService.get48HourForecastByCityName(cityName), HttpStatus.OK);
    }
}
