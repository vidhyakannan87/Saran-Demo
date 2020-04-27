package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.Controller.StudentController;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Service.StudentService;
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
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }

    @Override
    public void addAStudent(@RequestBody Student student) {

        studentService.addStudent(student);
    }

    @Override
    public Student updateStudent(@RequestBody Student student, @PathVariable int studentId) {
        return studentService.updateStudent(student, studentId);
    }

    @Override
    public Student patchUpdateStudent(@RequestBody Student student,@PathVariable int studentId) {
        return studentService.patchUpdateStudent(student,studentId);
    }

    @Override
    public void deleteStudent(int studentId) {
        studentService.deleteStudent(studentId);
    }
}
