package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Model.Student;
import com.stripe.exception.StripeException;

import java.util.List;

public interface StudentService {

  List<Student> getAllStudents();

  Student getStudentById(long id);

  void addStudent(Student student);

  Student updateStudent(Student student, long studentId);

  Student patchUpdateStudent(Student student, long studentID);

  void deleteStudent(long studentId);

  void paySemesterFee(long id, StripeChargeRequest request) throws StripeException;

}
