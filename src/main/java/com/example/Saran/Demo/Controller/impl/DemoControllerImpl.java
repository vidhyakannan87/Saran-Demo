package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.Controller.DemoController;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Service.StudentService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoControllerImpl implements DemoController {

  private StudentService studentService;

  public DemoControllerImpl(StudentService studentService) {
    this.studentService = studentService;
  }

  @Override
  public List<Student> getAll() {
    return studentService.getAllStudents();
  }

  @Override
  public void addAStudent(@RequestBody Student student) {

    studentService.addStudent(student);
  }
}
