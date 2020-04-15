package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.API.Response.WeatherResponse;
import com.example.Saran.Demo.Controller.WeatherController;
import com.example.Saran.Demo.Service.WeatherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherControllerImpl implements WeatherController {

  private final WeatherService weatherService;

  public WeatherControllerImpl(WeatherService weatherService) {
    this.weatherService = weatherService;
  }

  @Override
  public WeatherResponse getWeatherByZip(@PathVariable String zip) throws JsonProcessingException {
    return weatherService.getWeatherDescriptionByZip(zip);
  }
}
