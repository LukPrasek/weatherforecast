package pl.lukaszprasek.weatherforecast.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @org.springframework.beans.factory.annotation.Value(("${openweathermap.api_key}"))
    private String apiKey;

    private RestTemplate restTemplate;


    public WeatherService() {
        restTemplate=new RestTemplate();
    }

    public String makeCall(String cityName, String country) {
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "," + country + "&mode=xml&appid="+apiKey, String.class);
    }

}
