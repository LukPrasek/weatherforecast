package pl.lukaszprasek.weatherforecast.service;

import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.lukaszprasek.weatherforecast.model.WeatherModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {

    @org.springframework.beans.factory.annotation.Value(("${openweathermap.api_key}"))
    private String apiKey;
    private RestTemplate restTemplate;

    public WeatherService() {
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
    }

    public WeatherModel makeCall(String cityName, String country) {
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
         MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(new MediaType[]{MediaType.ALL}));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q="
                + cityName + "," + country + "&appid=" + apiKey, WeatherModel.class);
    }


}
