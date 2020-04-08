package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.Controller.DemoController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoControllerImpl implements DemoController {
  @Override
  public String displayHelloWorld() {
    return "Hello World";
  }
}
