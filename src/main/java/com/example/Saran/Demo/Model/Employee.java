package com.example.Saran.Demo.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Employee {

  @Id
  private long employeeId;

  private String firstName;

  private String lastName;

  private EmployeeType employeeType = EmployeeType.TEACHING;

  private int salaryGrade;

  private String stripeConnectId;

  private String personalEmail;

  private String phoneNumber;

  private String address;
}
