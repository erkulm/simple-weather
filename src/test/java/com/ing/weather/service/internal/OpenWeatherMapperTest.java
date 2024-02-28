package com.ing.weather.service.internal;

import com.ing.weather.UnitTest;
import com.ing.weather.service.openweather.domain.City;
import com.ing.weather.service.openweather.domain.HourlyServiceResponse;
import com.ing.weather.service.openweather.domain.Main;
import com.ing.weather.service.openweather.domain.WeatherInfo;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;

class OpenWeatherMapperTest implements UnitTest {
    @Mock
    private HourlyServiceResponse serviceResponse;

    @Mock
    private City city;

    @Mock
    Main main;
    @Mock
    private WeatherInfo weatherInfo;

    @InjectMocks
    private OpenWeatherMapper mapper;


    @Test
    void shouldMapServiceResponseToTwoDaysForecast() {
        // given
        given(city.getName()).willReturn("London");
        given(serviceResponse.getCity()).willReturn(city);
        given(weatherInfo.getMain()).willReturn(main);
        given(main.getTempMax()).willReturn(10.0);
        given(main.getFeelsLike()).willReturn(10.0);
        given(main.getHumidity()).willReturn(70);
        given(serviceResponse.getWeatherInfo()).willReturn(List.of(weatherInfo));
        given(weatherInfo.getDtTxt()).willReturn("2024-02-28 00:00:00");
        // when
        TwoDaysForecast twoDaysForecast = mapper.map(serviceResponse);
        // then
        assertThat(twoDaysForecast.getCityName(), is(equalToIgnoringCase("London")));
        assertThat(LocalDateTime.now().minus(Duration.ofSeconds(5)).compareTo(LocalDateTime.parse(twoDaysForecast.getDateTime(), DateTimeFormatter.ISO_DATE_TIME)), is(-1));
        assertThat(LocalDateTime.now().plus(Duration.ofSeconds(5)).compareTo(LocalDateTime.parse(twoDaysForecast.getDateTime(), DateTimeFormatter.ISO_DATE_TIME)), is(1));

        assertThat(twoDaysForecast.getForecasts().size(), is(equalTo(1)));
        assertThat(twoDaysForecast.getMaximumTemperatureForNextTwoDays(), is(equalTo(10.0)));
        assertThat(twoDaysForecast.getForecasts().get(0).getMax(), is(equalTo(10.0)));
        assertThat(twoDaysForecast.getForecasts().get(0).getFeelsLike(), is(equalTo(10.0)));
        assertThat(twoDaysForecast.getForecasts().get(0).getHumidity(), is(equalTo(70)));

    }
}