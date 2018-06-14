package pl.lukaszprasek.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GlobalStat {
    @JsonProperty("main")
    private TempStats tempStats;
}
