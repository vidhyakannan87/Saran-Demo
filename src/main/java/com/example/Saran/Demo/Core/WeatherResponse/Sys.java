package com.example.Saran.Demo.Core.WeatherResponse;

import lombok.Data;

@Data
public class Sys {

  private int type;

  private int id;

  private String country;

  private String sunrise;

  private String sunset;
}
