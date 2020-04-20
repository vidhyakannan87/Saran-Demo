package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Model.Student;
import com.stripe.exception.StripeException;

import java.util.List;

public interface StudentService {

  List<Student> getAllStudents();

  void addStudent(Student student);

  Student getAStudent(long id);

  void paySemesterFee(long id, StripeChargeRequest request) throws StripeException;

}
