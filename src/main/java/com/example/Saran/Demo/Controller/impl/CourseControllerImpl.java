package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.Controller.CourseController;
import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Service.CourseService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseControllerImpl implements CourseController {

  private final CourseService courseService;

  public CourseControllerImpl(CourseService courseService) {
    this.courseService = courseService;
  }

  @Override
  public void addACourse(@RequestBody Course course) {
    courseService.addACourse(course);
  }

  //Bad example but will still solve the purpose
  @Override
  public List<Course> getByDepartmentName(@PathVariable String deptName) {
    return courseService.getByDepartmentName(deptName);
  }
}
