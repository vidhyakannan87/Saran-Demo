package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.API.Response.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather")
public interface WeatherController {

  @GetMapping("/{zip}")
  WeatherResponse getWeatherByZip(@PathVariable String zip) throws JsonProcessingException;
}
