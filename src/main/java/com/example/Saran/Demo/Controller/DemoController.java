package com.example.Saran.Demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface DemoController {

  @GetMapping
   String displayHelloWorld();

}
