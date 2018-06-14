package pl.lukaszprasek.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lukaszprasek.weatherforecast.model.WeatherModel;
import pl.lukaszprasek.weatherforecast.service.WeatherService;

@Controller
public class MainController {
    private WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }
    @GetMapping("/")
    @ResponseBody
    public int index() {
        return weatherService.makeCall("München", "de").getGlobalStat().getTempStats().getTemp();
    }

    @GetMapping("/test")
    @ResponseBody
    public String indexTest() {
        return weatherService.makeTestCall("München", "de");
    }

}
