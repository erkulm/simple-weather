
package com.ing.weather.service.openweather.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "dt",
        "main",
        "weather",
        "clouds",
        "wind",
        "visibility",
        "pop",
        "sys",
        "dt_txt",
        "rain"
})
@Getter
@Setter
public class WeatherInfo {

    @JsonProperty("dt")
    public Integer dt;
    @JsonProperty("main")
    @Valid
    public Main main;
    @JsonProperty("weather")
    @Valid
    public java.util.List<Weather> weather;
    @JsonProperty("clouds")
    @Valid
    public Clouds clouds;
    @JsonProperty("wind")
    @Valid
    public Wind wind;
    @JsonProperty("visibility")
    public Integer visibility;
    @JsonProperty("pop")
    public Double pop;
    @JsonProperty("sys")
    @Valid
    public Sys sys;
    @JsonProperty("dt_txt")
    public String dtTxt;
    @JsonProperty("rain")
    @Valid
    public Rain rain;
    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WeatherInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("dt");
        sb.append('=');
        sb.append(((this.dt == null) ? "<null>" : this.dt));
        sb.append(',');
        sb.append("main");
        sb.append('=');
        sb.append(((this.main == null) ? "<null>" : this.main));
        sb.append(',');
        sb.append("weather");
        sb.append('=');
        sb.append(((this.weather == null) ? "<null>" : this.weather));
        sb.append(',');
        sb.append("clouds");
        sb.append('=');
        sb.append(((this.clouds == null) ? "<null>" : this.clouds));
        sb.append(',');
        sb.append("wind");
        sb.append('=');
        sb.append(((this.wind == null) ? "<null>" : this.wind));
        sb.append(',');
        sb.append("visibility");
        sb.append('=');
        sb.append(((this.visibility == null) ? "<null>" : this.visibility));
        sb.append(',');
        sb.append("pop");
        sb.append('=');
        sb.append(((this.pop == null) ? "<null>" : this.pop));
        sb.append(',');
        sb.append("sys");
        sb.append('=');
        sb.append(((this.sys == null) ? "<null>" : this.sys));
        sb.append(',');
        sb.append("dtTxt");
        sb.append('=');
        sb.append(((this.dtTxt == null) ? "<null>" : this.dtTxt));
        sb.append(',');
        sb.append("rain");
        sb.append('=');
        sb.append(((this.rain == null) ? "<null>" : this.rain));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length() - 1)) == ',') {
            sb.setCharAt((sb.length() - 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result * 31) + ((this.dt == null) ? 0 : this.dt.hashCode()));
        result = ((result * 31) + ((this.pop == null) ? 0 : this.pop.hashCode()));
        result = ((result * 31) + ((this.rain == null) ? 0 : this.rain.hashCode()));
        result = ((result * 31) + ((this.visibility == null) ? 0 : this.visibility.hashCode()));
        result = ((result * 31) + ((this.dtTxt == null) ? 0 : this.dtTxt.hashCode()));
        result = ((result * 31) + ((this.weather == null) ? 0 : this.weather.hashCode()));
        result = ((result * 31) + ((this.main == null) ? 0 : this.main.hashCode()));
        result = ((result * 31) + ((this.clouds == null) ? 0 : this.clouds.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.sys == null) ? 0 : this.sys.hashCode()));
        result = ((result * 31) + ((this.wind == null) ? 0 : this.wind.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherInfo) == false) {
            return false;
        }
        WeatherInfo rhs = ((WeatherInfo) other);
        return ((((((((((((this.dt == rhs.dt) || ((this.dt != null) && this.dt.equals(rhs.dt))) && ((this.pop == rhs.pop) || ((this.pop != null) && this.pop.equals(rhs.pop)))) && ((this.rain == rhs.rain) || ((this.rain != null) && this.rain.equals(rhs.rain)))) && ((this.visibility == rhs.visibility) || ((this.visibility != null) && this.visibility.equals(rhs.visibility)))) && ((this.dtTxt == rhs.dtTxt) || ((this.dtTxt != null) && this.dtTxt.equals(rhs.dtTxt)))) && ((this.weather == rhs.weather) || ((this.weather != null) && this.weather.equals(rhs.weather)))) && ((this.main == rhs.main) || ((this.main != null) && this.main.equals(rhs.main)))) && ((this.clouds == rhs.clouds) || ((this.clouds != null) && this.clouds.equals(rhs.clouds)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.sys == rhs.sys) || ((this.sys != null) && this.sys.equals(rhs.sys)))) && ((this.wind == rhs.wind) || ((this.wind != null) && this.wind.equals(rhs.wind))));
    }

}
