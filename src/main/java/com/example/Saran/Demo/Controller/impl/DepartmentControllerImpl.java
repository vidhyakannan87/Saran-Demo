package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.Controller.DepartmentController;
import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import com.example.Saran.Demo.Service.DepartmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentControllerImpl implements DepartmentController {

  private final DepartmentService departmentService;

  public DepartmentControllerImpl(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @Override
  public void addADepartment(@RequestBody Department department) {
    departmentService.addADepartment(department);
  }

  @Override
  public List<Course> getCoursesByDepartmentName(@PathVariable long deptId) {
    return departmentService.getCoursesByDepartmentId(deptId);
  }

}
