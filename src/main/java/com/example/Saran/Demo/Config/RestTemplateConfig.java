package com.example.Saran.Demo.Config;

import com.example.Saran.Demo.API.Response.WeatherResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfig {

  public static ResponseEntity<WeatherResponse> doGet(String baseUrl, RestTemplate restTemplate) {

    HttpEntity<?> entity = getHttpEntity();
    return restTemplate.exchange(baseUrl, HttpMethod.GET, entity, WeatherResponse.class);
  }

  private static HttpEntity<Object> getHttpEntity() {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    return new HttpEntity<>(headers);
  }

}
