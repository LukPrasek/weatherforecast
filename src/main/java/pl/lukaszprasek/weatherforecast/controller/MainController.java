package pl.lukaszprasek.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.lukaszprasek.weatherforecast.service.WeatherService;

import java.util.stream.Collectors;

@Controller
public class MainController {
    private WeatherService weatherService;

    @Autowired
    public MainController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public String index() {
        //weatherService.makeCall("Warszawa", "pl").getGlobalStatList().toString();
        return "index";
    }

    @PostMapping("/")
    public String postCity(@RequestParam("city") String city, @RequestParam("country") String country, Model model) {
        model.addAttribute("city", city);
        model.addAttribute("time", weatherService.makeCall(city, country).getGlobalStatList());
        model.addAttribute("weather", weatherService.makeCall(city, country)
                .getGlobalStatList()
                .stream().map(globalStat -> globalStat.getTempStats())
                .collect(Collectors.toList()));
        return "index";
    }

}
