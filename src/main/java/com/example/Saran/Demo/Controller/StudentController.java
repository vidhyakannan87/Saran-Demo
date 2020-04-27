package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
public interface StudentController {

  @GetMapping
  List<Student> getAll();

  @GetMapping("/{id}")
  Student getStudentById(@PathVariable int id);

  @PostMapping
  void addAStudent(@RequestBody Student student);

  @PutMapping("/{studentId}")
  Student updateStudent(@RequestBody Student student,@PathVariable int studentId);

  @PatchMapping("/{studentID}")
  Student patchUpdateStudent(@RequestBody Student student,@PathVariable int studentId);

  @DeleteMapping("/{studentId}")
  void deleteStudent(@PathVariable int studentId);

}
