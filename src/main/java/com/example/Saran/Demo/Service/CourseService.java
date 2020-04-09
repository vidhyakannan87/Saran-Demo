package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.Model.Course;

import java.util.List;

public interface CourseService {

  void addACourse(Course course);

  List<Course>  getByDepartmentName(String deptName);
}
