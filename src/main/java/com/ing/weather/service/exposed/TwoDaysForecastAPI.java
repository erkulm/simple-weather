package com.ing.weather.service.exposed;

import com.ing.weather.service.internal.TwoDaysForecast;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Weather Forecast", description = "Weather Forecast for the next 48 hours")
public interface TwoDaysForecastAPI {

    @Operation(
            summary = "Fetch Weather Forecast By City",
            description = "Fetches weather forecast with an interval of three hours for next 48 for a given city")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "city not found"),
            @ApiResponse(responseCode = "5xx", description = "internal error")
    })
    @Valid
    ResponseEntity<TwoDaysForecast> getForecast(@PathVariable(name = "cityName") @NotBlank @Size(max = 100, min = 2) String cityName);
}
