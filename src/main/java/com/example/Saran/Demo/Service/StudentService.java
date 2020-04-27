package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.Model.Student;

import java.util.List;

public interface StudentService {

  List<Student> getAllStudents();

  Student getStudentById(int id);

  void addStudent(Student student);

  Student updateStudent(Student student,int studentId);

  Student patchUpdateStudent(Student student, int studentID);

  void deleteStudent(int studentId);

}
