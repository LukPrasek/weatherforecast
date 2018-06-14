package pl.lukaszprasek.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String index() {
        return weatherService.makeCall("München", "de");
    }

}
