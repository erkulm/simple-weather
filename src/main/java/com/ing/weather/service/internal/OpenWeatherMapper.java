package com.ing.weather.service.internal;

import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import com.ing.weather.service.openweather.domain.WeatherInfo;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

@Component
public class OpenWeatherMapper {

    public TwoDaysForecast map(HourlyServiceResponse serviceResponse) {
        TwoDaysForecast twoDaysForecast = new TwoDaysForecast();
        twoDaysForecast.setCityName(serviceResponse.getCity().getName());
        twoDaysForecast.setDateTime(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        serviceResponse.getWeatherInfo().forEach(addToForecast(twoDaysForecast));
        twoDaysForecast.setMaximumTemperatureForNextTwoDays(maximumTemperatureForNextTwoDays(twoDaysForecast));
        return twoDaysForecast;
    }

    private static Double maximumTemperatureForNextTwoDays(TwoDaysForecast twoDaysForecast) {
        return twoDaysForecast.getForecasts().stream().map(ThreeHourForecast::getMax).max(Double::compareTo).orElse(null);
    }

    private Consumer<WeatherInfo> addToForecast(TwoDaysForecast twoDaysForecast) {
        return e -> twoDaysForecast.getForecasts().add(getThreeHourForeCast(e));
    }

    private ThreeHourForecast getThreeHourForeCast(WeatherInfo e) {
        return ThreeHourForecast.builder()
                .max(e.getMain().getTempMax())
                .feelsLike(e.getMain().getFeelsLike())
                .humidity(e.getMain().getHumidity())
                .time(formattedDate(e))
                .build();
    }

    private static String formattedDate(WeatherInfo e) {
        return LocalDateTime.parse(e.getDtTxt(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}
