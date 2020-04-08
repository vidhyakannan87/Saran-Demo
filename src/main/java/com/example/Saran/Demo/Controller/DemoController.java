package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/student")
public interface DemoController {

  @GetMapping
  List<Student> getAll();

}
