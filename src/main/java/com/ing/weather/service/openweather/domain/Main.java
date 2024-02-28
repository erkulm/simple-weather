
package com.ing.weather.service.openweather.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "temp",
        "feels_like",
        "temp_min",
        "temp_max",
        "pressure",
        "sea_level",
        "grnd_level",
        "humidity",
        "temp_kf"
})
@Getter
@Setter
public class Main {

    @JsonProperty("temp")
    public Double temp;
    @JsonProperty("feels_like")
    public Double feelsLike;
    @JsonProperty("temp_min")
    public Double tempMin;
    @JsonProperty("temp_max")
    public Double tempMax;
    @JsonProperty("pressure")
    public Integer pressure;
    @JsonProperty("sea_level")
    public Integer seaLevel;
    @JsonProperty("grnd_level")
    public Integer grndLevel;
    @JsonProperty("humidity")
    public Integer humidity;
    @JsonProperty("temp_kf")
    public Integer tempKf;
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
        sb.append(Main.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("temp");
        sb.append('=');
        sb.append(((this.temp == null) ? "<null>" : this.temp));
        sb.append(',');
        sb.append("feelsLike");
        sb.append('=');
        sb.append(((this.feelsLike == null) ? "<null>" : this.feelsLike));
        sb.append(',');
        sb.append("tempMin");
        sb.append('=');
        sb.append(((this.tempMin == null) ? "<null>" : this.tempMin));
        sb.append(',');
        sb.append("tempMax");
        sb.append('=');
        sb.append(((this.tempMax == null) ? "<null>" : this.tempMax));
        sb.append(',');
        sb.append("pressure");
        sb.append('=');
        sb.append(((this.pressure == null) ? "<null>" : this.pressure));
        sb.append(',');
        sb.append("seaLevel");
        sb.append('=');
        sb.append(((this.seaLevel == null) ? "<null>" : this.seaLevel));
        sb.append(',');
        sb.append("grndLevel");
        sb.append('=');
        sb.append(((this.grndLevel == null) ? "<null>" : this.grndLevel));
        sb.append(',');
        sb.append("humidity");
        sb.append('=');
        sb.append(((this.humidity == null) ? "<null>" : this.humidity));
        sb.append(',');
        sb.append("tempKf");
        sb.append('=');
        sb.append(((this.tempKf == null) ? "<null>" : this.tempKf));
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
        result = ((result * 31) + ((this.feelsLike == null) ? 0 : this.feelsLike.hashCode()));
        result = ((result * 31) + ((this.tempMax == null) ? 0 : this.tempMax.hashCode()));
        result = ((result * 31) + ((this.temp == null) ? 0 : this.temp.hashCode()));
        result = ((result * 31) + ((this.seaLevel == null) ? 0 : this.seaLevel.hashCode()));
        result = ((result * 31) + ((this.humidity == null) ? 0 : this.humidity.hashCode()));
        result = ((result * 31) + ((this.pressure == null) ? 0 : this.pressure.hashCode()));
        result = ((result * 31) + ((this.tempKf == null) ? 0 : this.tempKf.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.grndLevel == null) ? 0 : this.grndLevel.hashCode()));
        result = ((result * 31) + ((this.tempMin == null) ? 0 : this.tempMin.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Main) == false) {
            return false;
        }
        Main rhs = ((Main) other);
        return (((((((((((this.feelsLike == rhs.feelsLike) || ((this.feelsLike != null) && this.feelsLike.equals(rhs.feelsLike))) && ((this.tempMax == rhs.tempMax) || ((this.tempMax != null) && this.tempMax.equals(rhs.tempMax)))) && ((this.temp == rhs.temp) || ((this.temp != null) && this.temp.equals(rhs.temp)))) && ((this.seaLevel == rhs.seaLevel) || ((this.seaLevel != null) && this.seaLevel.equals(rhs.seaLevel)))) && ((this.humidity == rhs.humidity) || ((this.humidity != null) && this.humidity.equals(rhs.humidity)))) && ((this.pressure == rhs.pressure) || ((this.pressure != null) && this.pressure.equals(rhs.pressure)))) && ((this.tempKf == rhs.tempKf) || ((this.tempKf != null) && this.tempKf.equals(rhs.tempKf)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.grndLevel == rhs.grndLevel) || ((this.grndLevel != null) && this.grndLevel.equals(rhs.grndLevel)))) && ((this.tempMin == rhs.tempMin) || ((this.tempMin != null) && this.tempMin.equals(rhs.tempMin))));
    }

}
