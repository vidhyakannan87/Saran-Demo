package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;

import java.util.List;

public interface DepartmentService {

  void addADepartment(Department department);

  List<Course> getCoursesByDepartmentId(long deptId);
}
