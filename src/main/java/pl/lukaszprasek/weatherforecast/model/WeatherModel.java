package pl.lukaszprasek.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeatherModel {
    @JsonProperty("list")
    private List<GlobalStat> globalStatList;

    public WeatherModel() {
        globalStatList = new ArrayList<>();
    }
}
