package com.example.Saran.Demo.Core.WeatherResponse;

import lombok.Data;

@Data
public class Weather {

  private int id;

  private String main;

  private String description;

  private String icon;
}
