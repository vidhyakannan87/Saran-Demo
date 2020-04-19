package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Course;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CourseController {

  @PostMapping
  void addACourse(@RequestBody Course course);
}
