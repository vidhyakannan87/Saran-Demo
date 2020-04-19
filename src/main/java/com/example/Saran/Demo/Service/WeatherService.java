package com.example.Saran.Demo.Service;


import com.example.Saran.Demo.API.Response.WeatherResponse;

public interface WeatherService {

  WeatherResponse getWeatherDescriptionByZip(String zip, String country);

  WeatherResponse getWeatherDescriptionByCityName(String cityName);

}
