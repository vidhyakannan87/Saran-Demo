package com.example.Saran.Demo.Core.WeatherResponse;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wind {

  private long speed;

  private long deg;

}
