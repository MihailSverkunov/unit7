package pro.sisit.javacource.unit7.web.impl;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import pro.sisit.javacource.unit7.dto.WeatherDTO;
import pro.sisit.javacource.unit7.web.WeatherService;

import java.net.URI;

@Service
public class WeatherServiceRestImpl implements WeatherService {

    private RestTemplate restTemplate;
    private static String URL_WEATHER = "https://api.openweathermap.org/data/2.5/weather?units=metric&mode=json&q=%s&appid=b58f59dc668604bbc47186b286dc9ca5";

    public WeatherServiceRestImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String getWeather(String city) {

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        //        headers.add("units", "metric");
//        headers.add("mode", "json");
//        headers.add("q", city);
//        headers.add("appid", "b58f59dc668604bbc47186b286dc9ca5");


        RequestEntity requestEntity = new RequestEntity(null, HttpMethod.GET, URI.create(String.format(URL_WEATHER, city)));
        ResponseEntity<WeatherDTO> responseEntity = restTemplate.exchange(requestEntity, WeatherDTO.class);

        return responseEntity.getBody().getMain().getTemp();
    }


}
