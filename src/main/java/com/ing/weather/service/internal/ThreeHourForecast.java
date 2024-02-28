package com.ing.weather.service.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ThreeHourForecast {
    Double max;
    Double feelsLike;
    Integer humidity;
    String time;
}
