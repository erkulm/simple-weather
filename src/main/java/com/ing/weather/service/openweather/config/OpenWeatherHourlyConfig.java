package com.ing.weather.service.openweather.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "openweather.hourly")
@Getter
@Setter
public class OpenWeatherHourlyConfig {
    String baseUrl;
    String apiKey;
    String cnt;
    String units;
}
