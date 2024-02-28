package com.ing.weather.service.exposed;

import com.ing.weather.service.exceptions.CityNotFoundException;
import com.ing.weather.service.internal.ThreeHourForecast;
import com.ing.weather.service.internal.TwoDaysForecast;
import com.ing.weather.service.internal.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TwoDaysForecastRestController.class)
class TwoDaysForecastRestControllerTest {
    @MockBean
    private WeatherService weatherService;
    @Autowired
    MockMvc mockMvc;

    @Autowired
    TwoDaysForecastRestController twoDaysForecastRestController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(twoDaysForecastRestController)
                .setControllerAdvice(new ControllerAdvisor())
                .build();
    }

    @Test
    @DisplayName("Should return forecast for a given city")
    void testGetForecast() throws Exception {
        // Given
        String cityName = "London";
        TwoDaysForecast expectedForecast = new TwoDaysForecast();
        expectedForecast.setCityName(cityName);
        expectedForecast.getForecasts().add(ThreeHourForecast.builder().max(35.0).feelsLike(35.0).humidity(50).build());
        when(weatherService.get48HourForecastByCityName(cityName)).thenReturn(expectedForecast);

        mockMvc.perform(MockMvcRequestBuilders.get("/two-days/" + cityName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cityName", is(cityName)))
                .andExpect(jsonPath("$.forecasts[0].max", is(35.0)))
                .andExpect(jsonPath("$.forecasts[0].feelsLike", is(35.0)))
                .andExpect(jsonPath("$.forecasts[0].humidity", is(50)))
                .andExpect(jsonPath("$.forecasts.size()", is(1)));
    }

    @Test
    @DisplayName("Should return 404 Not Found when city name is not found")
    void testGetForecastCityNotFound() throws Exception {
        String cityName = "NonexistentCity";
        when(weatherService.get48HourForecastByCityName(cityName))
                .thenThrow(new CityNotFoundException(String.format("City could not be found: %s", cityName)));

        mockMvc.perform(MockMvcRequestBuilders.get("/two-days/" + cityName))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is(String.format("City could not be found: %s", cityName))));
    }

    @Test
    @DisplayName("Should return 400 Bad Request when city name is not valid")
    void testGetForecastInvalidCityName() throws Exception {
        String invalidCityName = "C";

        mockMvc.perform(MockMvcRequestBuilders.get("/two-days/" + invalidCityName))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status", is(400)))
                .andExpect(jsonPath("$.title", is("Bad Request")));
    }
}
