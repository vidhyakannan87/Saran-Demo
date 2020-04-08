package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Repository.StudentRepository;
import com.example.Saran.Demo.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


  private final StudentRepository studentRepository;


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
}
