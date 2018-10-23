package pl.lukaszprasek.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TempStats {
    @JsonProperty("temp")
    private int temp;

    @JsonProperty("pressure")
    private int pressure;

    @JsonProperty("humidity")
    private int humidity;

    private LocalDateTime date;

    public TempStats() {
        date = new GlobalStat().getDate();
    }
}
