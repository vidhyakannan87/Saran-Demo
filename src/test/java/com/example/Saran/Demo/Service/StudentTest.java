package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Repository.StudentRepository;
import com.example.Saran.Demo.Service.impl.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.example.Saran.Demo.Service.Utility.CreateTestObjects.createTestStudent;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StudentTest {

  private StudentServiceImpl studentServiceImpl;
  private StudentRepository studentRepository;
  private TwilioService twilioService;

  @Before
  public void setUp() {
    this.studentRepository = mock(StudentRepository.class);
    this.twilioService = mock(TwilioService.class);
    this.studentServiceImpl = new StudentServiceImpl(studentRepository, twilioService);
  }


  @Test(expected = EntityNotFoundException.class)
  public void loadStudentByIdEntityNotFoundTest() {
    studentServiceImpl.getStudentById(-1);
  }


  @Test
  public void getAllStudentsTest() {

    Student testStudent1 = createTestStudent();
    Student testStudent2 = createTestStudent();

    List<Student> list = new ArrayList<>();
    list.add(testStudent1);
    list.add(testStudent2);

    when(studentRepository.findAll()).thenReturn(list);
    List<Student> studentList = studentServiceImpl.getAllStudents();

    assertEquals(studentList.size(), 2);

  }

  @Test
  public void getStudentTest() {
    long id = 1L;
    Student testStudent = createTestStudent();
    testStudent.setId(id);

    when(studentRepository.findById(id)).thenReturn(java.util.Optional.of(testStudent));
    Student student = studentServiceImpl.getStudentById(id);
    assertTrue(student.getFirstName().equals(testStudent.getFirstName()));
  }

  @Test
  public void updateStudentTest() {
    long id = 1L;
    Student testStudent = createTestStudent();
    testStudent.setId(id);

    Student newStudent = createTestStudent();
    newStudent.setPhoneNumber("New Phone Number");

    when(studentRepository.findById(id)).thenReturn(java.util.Optional.of(testStudent));
    assertTrue(studentServiceImpl.updateStudent(newStudent, id).getPhoneNumber().equals(newStudent.getPhoneNumber()));

  }


  @Test
  public void patchStudentTest() {
    long id = 1L;
    Student testStudent = createTestStudent();
    testStudent.setId(id);

    Student newStudent = createTestStudent();
    newStudent.setFirstName("New First Name");

    when(studentRepository.findById(id)).thenReturn(java.util.Optional.of(testStudent));
    Student updatedStudent = studentServiceImpl.updateStudent(newStudent, id);
    assertTrue(updatedStudent.getFirstName().equals(newStudent.getFirstName()));
    assertTrue(updatedStudent.getLastName().equals(testStudent.getLastName()));
    assertTrue(updatedStudent.getDob().equals(testStudent.getDob()));
    assertTrue(updatedStudent.getEmail().equals(testStudent.getEmail()));


  }


}
