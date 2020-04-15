package com.example.Saran.Demo.Core.WeatherResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sys {

  private int type;

  private int id;

  private String country;

  private String sunrise;

  private String sunset;
}
