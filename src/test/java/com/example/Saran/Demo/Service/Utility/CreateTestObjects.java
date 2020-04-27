package com.example.Saran.Demo.Service.Utility;

import com.example.Saran.Demo.Model.Address;
import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import com.example.Saran.Demo.Model.Student;

import java.util.ArrayList;
import java.util.List;

public class CreateTestObjects {


  public static Address createTestAddress() {

    Address address = new Address();
    address.setLine1("Test Line 1");
    address.setLine2("Test Line2");
    address.setCity("City");
    address.setPostalCode("code");
    address.setState("state");
    address.setCountry("country");
    return address;

  }

  public static Student createTestStudent() {
    Student student = new Student();
    student.setFirstName("First Name");
    student.setLastName("Last Name");
    student.setDob("1987-12-10");
    student.setEmail("testemail@test.com");
    student.setPhoneNumber("+12025550118");
    student.setAddress(createTestAddress());
    return student;
  }


  public static Course createTestCourse() {
    Course course = new Course();
    course.setTitle("Test Course");
    course.setCourseId("TEST 001");
    course.setCredits(4);

    return course;
  }


  public static Department createTestDepartment() {

    List<Course> courseList = new ArrayList<>();
    courseList.add(createTestCourse());

    Department department = new Department();
    department.setBudget(3200L);
    department.setName("Test Dept");
    department.setCourseList(courseList);

    return department;
  }

}
