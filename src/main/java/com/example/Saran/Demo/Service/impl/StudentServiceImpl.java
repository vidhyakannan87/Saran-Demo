package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Repository.StudentRepository;
import com.example.Saran.Demo.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Student getStudentById(int id) {
        Optional<Student> oldStudent = studentRepository.findById(id);
        if (oldStudent.isPresent()) {
            return oldStudent.get();
        }
        //throw new BadRequestException("Student not found") ;
        return null;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.insert(student);
    }

    @Override
    public Student updateStudent(Student student, int studentId) {
        Student oldStudent = findByID(studentId);
        if (oldStudent != null) {
            oldStudent = student;
            oldStudent.setStudentId(studentId);
            studentRepository.save(oldStudent);
            return oldStudent;
        }
        student.setStudentId(studentId);
        studentRepository.insert(student);
        return student;
    }

    @Override
    public Student patchUpdateStudent(Student student, int studentID) {
        Student oldStudent = findByID(studentID);
        if (oldStudent != null) {
            oldStudent.setFirstName(student.getFirstName());
            studentRepository.save(oldStudent);
            return oldStudent;
        }
        return null;
    }

    @Override
    public void deleteStudent(int studentId) {
        Student oldStudent = findByID(studentId);
        if (oldStudent != null) {
            studentRepository.delete(oldStudent);
        }
    }

    public Student findByID(int studentId) {
        Optional<Student> oldStudent = studentRepository.findById(studentId);
        if (oldStudent.isPresent()) {
            return oldStudent.get();
        }
        return null;
    }
}