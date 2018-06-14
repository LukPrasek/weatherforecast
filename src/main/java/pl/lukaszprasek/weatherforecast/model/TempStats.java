package pl.lukaszprasek.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TempStats {
    @JsonProperty("temp")
    private int temp;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;
}
