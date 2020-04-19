package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Repository.StudentRepository;
import com.example.Saran.Demo.Service.StripeService;
import com.example.Saran.Demo.Service.StudentService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


  private final StudentRepository studentRepository;

  @Autowired //Equal to instantiating and creating an object of a class in this case it is Stripe Service
  private StripeService stripeService;


  public StudentServiceImpl(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @Override
  public List<Student> getAllStudents() {

    return studentRepository.findAll();
  }


  @Override
  public void addStudent(Student student) {
    studentRepository.insert(student);
  }

  @Override
  public Student getAStudent(String id) {
    Optional<Student> optionalStudent = Optional.ofNullable(studentRepository.findByStudentId(id));
    if (optionalStudent.isPresent()) {
      return optionalStudent.get();
    } else {
      throw new BadRequestException("Invalid Student Id");
    }

  }

  @Override
  public void paySemesterFee(String id, StripeChargeRequest stripeChargeRequest) throws StripeException {
    Student student = getAStudent(id);
    stripeService.createStripeCharge(stripeChargeRequest.getAmount(), stripeChargeRequest.getStripeToken(),student);
  }
}
