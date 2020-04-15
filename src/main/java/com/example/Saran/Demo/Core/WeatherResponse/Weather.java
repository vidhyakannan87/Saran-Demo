package com.example.Saran.Demo.Core.WeatherResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Weather {

  private int id;

  private String main;

  private String description;

  private String icon;
}
