package com.ing.weather.service.openweather;

import com.ing.weather.service.exceptions.CityNotFoundException;
import com.ing.weather.service.exceptions.OpenWeatherException;
import com.ing.weather.service.openweather.config.OpenWeatherHourlyConfig;
import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class OpenWeatherHourlyService {
    private final OpenWeatherHourlyConfig config;
    private final RestTemplate restTemplate;

    public ResponseEntity<HourlyServiceResponse> getWeather(String cityName) {
        log.info("Open weather api is called for: {}", cityName);
        ResponseEntity<HourlyServiceResponse> exchange = null;
        try {
            exchange = restTemplate.exchange(urlTemplate(), HttpMethod.GET, httpEntity(), HourlyServiceResponse.class, queryParams(cityName));
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
                throw new CityNotFoundException(String.format("City could not be found: %s", cityName));
            } else {
                throw new OpenWeatherException(String.format("Error Code: %d", e.getStatusCode().value()));
            }
        }
        return exchange;
    }


    private static HttpEntity<String> httpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>("parameters", headers);
    }

    private Map<String, String> queryParams(String cityName) {
        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("appid", config.getApiKey());
        params.put("cnt", config.getCnt());
        params.put("units", config.getUnits());
        return params;
    }

    private String urlTemplate() {
        return UriComponentsBuilder.fromHttpUrl(config.getBaseUrl())
                .queryParam("q", "{q}")
                .queryParam("appid", "{appid}")
                .queryParam("cnt", "{cnt}")
                .queryParam("units", "{units}")
                .encode()
                .toUriString();
    }
}
