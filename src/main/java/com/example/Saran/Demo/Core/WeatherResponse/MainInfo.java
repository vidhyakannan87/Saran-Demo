package com.example.Saran.Demo.Core.WeatherResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainInfo {

  private long temp;

  private long feels_like;

  private long temp_min;

  private long temp_max;

  private int pressure;

  private int humidity;

}
