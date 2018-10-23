package pl.lukaszprasek.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class GlobalStat {
    @JsonProperty("dt_txt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    //"dt_txt":"2014-07-23 09:00:00"
    private LocalDateTime date;

    @JsonProperty("main")
    private TempStats tempStats;

}
