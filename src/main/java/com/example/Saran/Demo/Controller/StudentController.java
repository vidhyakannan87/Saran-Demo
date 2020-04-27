package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Model.Student;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
public interface StudentController {

  @GetMapping
  List<Student> getAll();

  @GetMapping("/{id}")
  Student getStudentById(@PathVariable long id);

  @PostMapping
  void addAStudent(@RequestBody Student student);

  @PutMapping("/{studentId}")
  Student updateStudent(@RequestBody Student student, @PathVariable long studentId);

  @PatchMapping("/{studentID}")
  Student patchUpdateStudent(@RequestBody Student student, @PathVariable long studentId);

  @DeleteMapping("/{studentId}")
  void deleteStudent(@PathVariable long studentId);

  @PostMapping("/{id}/payment")
  void addPayment(@PathVariable long id, @RequestBody StripeChargeRequest stripeChargeRequest) throws StripeException;

}
