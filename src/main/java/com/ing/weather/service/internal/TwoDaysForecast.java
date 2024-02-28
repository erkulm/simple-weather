package com.ing.weather.service.internal;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TwoDaysForecast {
    String cityName;
    String dateTime;
    Double maximumTemperatureForNextTwoDays;
    ArrayList<ThreeHourForecast> forecasts = new ArrayList<>(16);
}
