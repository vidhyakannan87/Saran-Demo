package com.example.Saran.Demo.Config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class RestTemplateConfig {

  public static String doGet(String baseUrl, RestTemplate restTemplate) {

    HttpEntity<?> entity = getHttpEntity();

    return restTemplate.exchange(baseUrl, HttpMethod.GET, entity, String.class).toString();
  }


  private static HttpEntity<Object> getHttpEntity() {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    return new HttpEntity<>(headers);
  }

}
