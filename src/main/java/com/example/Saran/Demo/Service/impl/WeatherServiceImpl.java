package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Response.WeatherResponse;
import com.example.Saran.Demo.Config.RestTemplateConfig;
import com.example.Saran.Demo.Service.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

  @Value("${openweather.apiKey}")
  private String openWeatherAPIKey;


  private final RestTemplate restTemplate;


  public WeatherServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }


  @Override
  public WeatherResponse getWeatherDescriptionByZip(String zip, String country) {
    String url = "http://api.openweathermap.org/data/2.5/weather?zip=%s,%s&appid=%s";
    url = String.format(url, zip, country, openWeatherAPIKey);

    WeatherResponse response = RestTemplateConfig.doGet(url, restTemplate).getBody();
    return response;


  }
}
