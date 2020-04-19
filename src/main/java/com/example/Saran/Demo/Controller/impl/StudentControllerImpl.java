package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Controller.StudentController;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Service.StudentService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentControllerImpl implements StudentController {

  private StudentService studentService;

  public StudentControllerImpl(StudentService studentService) {
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

  @Override
  public void addPayment(@PathVariable String id, @RequestBody StripeChargeRequest stripeChargeRequest) throws StripeException {

    studentService.paySemesterFee(id ,stripeChargeRequest);
  }
}
