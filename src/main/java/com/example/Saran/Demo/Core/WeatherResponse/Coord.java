package com.example.Saran.Demo.Core.WeatherResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coord {

  private long lon;

  private long lat;

}
