package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Response.WeatherResponse;
import com.example.Saran.Demo.Config.RestTemplateConfig;
import com.example.Saran.Demo.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl implements WeatherService {

  @Value("${openweather.apiKey}")
  private String openWeatherAPIKey;

  private ObjectMapper objectMapper;

  private final RestTemplate restTemplate;

  public WeatherServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
    this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
  }


  @Override
  public WeatherResponse getWeatherDescriptionByZip(String zip) throws JsonProcessingException {
    String url = "http://api.openweathermap.org/data/2.5/weather?zip=%s,US&appid=%s";
    url = String.format(url, zip, openWeatherAPIKey);
    String response = RestTemplateConfig.doGet(url, restTemplate);

    return objectMapper.readValue(response.replaceAll("\u003C200\u002C", ""), WeatherResponse.class);


  }
}
