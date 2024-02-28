
package com.ing.weather.service.openweather.domain;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "name",
        "coord",
        "country",
        "population",
        "timezone",
        "sunrise",
        "sunset"
})
@Getter
@Setter
public class City {

    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("coord")
    @Valid
    public Coord coord;
    @JsonProperty("country")
    public String country;
    @JsonProperty("population")
    public Integer population;
    @JsonProperty("timezone")
    public Integer timezone;
    @JsonProperty("sunrise")
    public Integer sunrise;
    @JsonProperty("sunset")
    public Integer sunset;
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
        sb.append(City.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null) ? "<null>" : this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null) ? "<null>" : this.name));
        sb.append(',');
        sb.append("coord");
        sb.append('=');
        sb.append(((this.coord == null) ? "<null>" : this.coord));
        sb.append(',');
        sb.append("country");
        sb.append('=');
        sb.append(((this.country == null) ? "<null>" : this.country));
        sb.append(',');
        sb.append("population");
        sb.append('=');
        sb.append(((this.population == null) ? "<null>" : this.population));
        sb.append(',');
        sb.append("timezone");
        sb.append('=');
        sb.append(((this.timezone == null) ? "<null>" : this.timezone));
        sb.append(',');
        sb.append("sunrise");
        sb.append('=');
        sb.append(((this.sunrise == null) ? "<null>" : this.sunrise));
        sb.append(',');
        sb.append("sunset");
        sb.append('=');
        sb.append(((this.sunset == null) ? "<null>" : this.sunset));
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
        result = ((result * 31) + ((this.country == null) ? 0 : this.country.hashCode()));
        result = ((result * 31) + ((this.coord == null) ? 0 : this.coord.hashCode()));
        result = ((result * 31) + ((this.sunrise == null) ? 0 : this.sunrise.hashCode()));
        result = ((result * 31) + ((this.timezone == null) ? 0 : this.timezone.hashCode()));
        result = ((result * 31) + ((this.sunset == null) ? 0 : this.sunset.hashCode()));
        result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
        result = ((result * 31) + ((this.population == null) ? 0 : this.population.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof City) == false) {
            return false;
        }
        City rhs = ((City) other);
        return ((((((((((this.country == rhs.country) || ((this.country != null) && this.country.equals(rhs.country))) && ((this.coord == rhs.coord) || ((this.coord != null) && this.coord.equals(rhs.coord)))) && ((this.sunrise == rhs.sunrise) || ((this.sunrise != null) && this.sunrise.equals(rhs.sunrise)))) && ((this.timezone == rhs.timezone) || ((this.timezone != null) && this.timezone.equals(rhs.timezone)))) && ((this.sunset == rhs.sunset) || ((this.sunset != null) && this.sunset.equals(rhs.sunset)))) && ((this.name == rhs.name) || ((this.name != null) && this.name.equals(rhs.name)))) && ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id)))) && ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null) && this.additionalProperties.equals(rhs.additionalProperties)))) && ((this.population == rhs.population) || ((this.population != null) && this.population.equals(rhs.population))));
    }

}
