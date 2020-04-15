package com.example.Saran.Demo.API.Response;

import com.example.Saran.Demo.Core.WeatherResponse.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
