package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/department")
public interface DepartmentController {

    @PostMapping
    void addADepartment(@RequestBody Department department);

    @GetMapping("/{deptName}")
    List<Course> getCoursesByDepartmentName(@PathVariable String deptName);

}
