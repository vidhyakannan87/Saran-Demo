package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Request.StripeChargeRequest;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Repository.StudentRepository;
import com.example.Saran.Demo.Service.StripeService;
import com.example.Saran.Demo.Service.StudentService;
import com.example.Saran.Demo.Service.TwilioService;
import com.stripe.exception.StripeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static com.example.Saran.Demo.Service.Utility.SmsUtility.WELCOME_SMS_STUDENT;

@Service
public class StudentServiceImpl implements StudentService {


  private final StudentRepository studentRepository;

  private final TwilioService twilioService;

  @Autowired //Equal to instantiating and creating an object of a class in this case it is Stripe Service
  private StripeService stripeService;


  public StudentServiceImpl(StudentRepository studentRepository, TwilioService twilioService) {
    this.studentRepository = studentRepository;
    this.twilioService = twilioService;
  }

  @Override
  public List<Student> getAllStudents() {

    return studentRepository.findAll();
  }


  @Override
  public Student getStudentById(long id) {
    Optional<Student> oldStudent = studentRepository.findById(id);
    if (oldStudent.isPresent()) {
      return oldStudent.get();
    }
    throw new EntityNotFoundException("Invalid Student Id");
  }

  @Override
  public void addStudent(Student student) {

    twilioService.sendSMS(student.getPhoneNumber(), String.format(WELCOME_SMS_STUDENT, student.getFirstName()));
    studentRepository.insert(student);


  }

  @Override
  public Student updateStudent(Student student, long studentId) {
    Student oldStudent = getStudentById(studentId);
    if (oldStudent != null) {
      oldStudent = student;
      oldStudent.setId(studentId);
      studentRepository.save(oldStudent);
      return oldStudent;
    }
    student.setId(studentId);
    studentRepository.insert(student);
    return student;
  }

  @Override
  public Student patchUpdateStudent(Student student, long studentID) {
    Student oldStudent = getStudentById(studentID);
    if (oldStudent != null) {
      oldStudent.setFirstName(student.getFirstName());
      studentRepository.save(oldStudent);
      return oldStudent;
    }
    return null;
  }

  @Override
  public void deleteStudent(long studentId) {
    Student oldStudent = getStudentById(studentId);
    if (oldStudent != null) {
      studentRepository.delete(oldStudent);
    }
  }

  @Override
  public void paySemesterFee(long id, StripeChargeRequest stripeChargeRequest) throws StripeException {
    Student student = getStudentById(id);
    stripeService.createStripeCharge(stripeChargeRequest.getAmount(), stripeChargeRequest.getStripeToken(), student);
  }

}