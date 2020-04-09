package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Repository.CourseRepository;
import com.example.Saran.Demo.Service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

  private final CourseRepository courseRepository;

  public CourseServiceImpl(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  @Override
  public void addACourse(Course course) {
    courseRepository.insert(course);
  }

  @Override
  public List<Course> getByDepartmentName(String deptName) {
    return courseRepository.findByDepartment_Name(deptName);
  }
}
