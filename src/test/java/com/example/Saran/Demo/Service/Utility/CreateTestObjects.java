package com.example.Saran.Demo.Service.Utility;

import com.example.Saran.Demo.Model.Address;
import com.example.Saran.Demo.Model.Student;

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

}
