package com.example.Saran.Demo.API.Response;

import com.example.Saran.Demo.Core.WeatherResponse.*;
import lombok.Data;

@Data
public class WeatherResponse {

  private Coord coord;

  private Weather[] weather;

  private String base;

  private MainInfo main;

  private int visibility;

  private Wind wind;

  private Clouds clouds;

  private String dt;

  private Sys sys;

  private String timezone;

  private int id;

  private String name;

  private int cod;


}
