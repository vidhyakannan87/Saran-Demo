package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
public interface DepartmentController {

  @PostMapping
  void addADepartment(@RequestBody Department department);

  @GetMapping("/{id}")
  Department getADepartment(@PathVariable long id);

  //I changed this to ID since it is more unique for every dept
  @GetMapping("/{deptId}/courses")
  List<Course> getCoursesByDepartment(@PathVariable long deptId);

}
