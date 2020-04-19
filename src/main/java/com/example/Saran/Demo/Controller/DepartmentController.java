package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
public interface DepartmentController {

  @PostMapping
  void addADepartment(@RequestBody Department department);


  //I changed this to ID since it is more unique for every dept
  @GetMapping("/{deptId}")
  List<Course> getCoursesByDepartmentName(@PathVariable long deptId);

}
