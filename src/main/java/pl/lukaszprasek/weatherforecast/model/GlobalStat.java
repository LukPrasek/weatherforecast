package pl.lukaszprasek.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class GlobalStat {
    @JsonProperty("main")
    private TempStats tempStats;
    @JsonProperty("dt_txt")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    //creationTime=2018-06-16 09:00:00
    //private String creationTime;
    //private LocalDateTime creationTime;
}
