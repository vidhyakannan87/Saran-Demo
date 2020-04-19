package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.API.Response.WeatherResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/weather")
public interface WeatherController {

  @GetMapping("/{zip}/{country}")
  WeatherResponse getWeatherByZip(@PathVariable String zip, @PathVariable String country);

  @GetMapping("/{cityName}")
  WeatherResponse getWeatherByCityName(@PathVariable String cityName);

}
