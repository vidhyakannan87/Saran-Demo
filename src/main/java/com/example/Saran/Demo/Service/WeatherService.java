package com.example.Saran.Demo.Service;


import com.example.Saran.Demo.API.Response.WeatherResponse;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface WeatherService {

  WeatherResponse getWeatherDescriptionByZip(String zip) throws JsonProcessingException;

}
