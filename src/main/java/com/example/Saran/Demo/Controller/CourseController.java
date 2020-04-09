package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Course;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
public interface CourseController {

  @PostMapping
  void addACourse(@RequestBody Course course);

  @GetMapping("/{deptName}")
  List<Course> getByDepartmentName(@PathVariable String deptName);

}
