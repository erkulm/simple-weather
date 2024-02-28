
package com.ing.weather.service.openweather.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cod",
        "message",
        "cnt",
        "list",
        "city"
})
@Getter
@Setter
public class HourlyServiceResponse {

    @JsonProperty("cod")
    public String cod;
    @JsonProperty("message")
    public Integer message;
    @JsonProperty("cnt")
    public Integer cnt;
    @JsonProperty("list")
    @Valid
    public java.util.List<WeatherInfo> weatherInfo;
    @JsonProperty("city")
    @Valid
    public City city;
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
        sb.append(HourlyServiceResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("cod");
        sb.append('=');
        sb.append(((this.cod == null) ? "<null>" : this.cod));
        sb.append(',');
        sb.append("message");
        sb.append('=');
        sb.append(((this.message == null) ? "<null>" : this.message));
        sb.append(',');
        sb.append("cnt");
        sb.append('=');
        sb.append(((this.cnt == null) ? "<null>" : this.cnt));
        sb.append(',');
        sb.append("list");
        sb.append('=');
        sb.append(((this.weatherInfo == null) ? "<null>" : this.weatherInfo));
        sb.append(',');
        sb.append("city");
        sb.append('=');
        sb.append(((this.city == null) ? "<null>" : this.city));
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
        result = ((result * 31) + ((this.city == null) ? 0 : this.city.hashCode()));
        result = ((result * 31) + ((this.cnt == null) ? 0 : this.cnt.hashCode()));
        result = ((result * 31) + ((this.cod == null) ? 0 : this.cod.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.message == null) ? 0 : this.message.hashCode()));
        result = ((result * 31) + ((this.weatherInfo == null) ? 0 : this.weatherInfo.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof HourlyServiceResponse) == false) {
            return false;
        }
        HourlyServiceResponse rhs = ((HourlyServiceResponse) other);
        return (((((((this.city == rhs.city) || ((this.city != null) && this.city.equals(rhs.city))) && ((this.cnt == rhs.cnt) || ((this.cnt != null) && this.cnt.equals(rhs.cnt)))) && ((this.cod == rhs.cod) || ((this.cod != null) && this.cod.equals(rhs.cod)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.message == rhs.message) || ((this.message != null) && this.message.equals(rhs.message)))) && ((this.weatherInfo == rhs.weatherInfo) || ((this.weatherInfo != null) && this.weatherInfo.equals(rhs.weatherInfo))));
    }

}
