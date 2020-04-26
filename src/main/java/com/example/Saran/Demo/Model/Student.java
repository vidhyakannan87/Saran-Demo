package com.example.Saran.Demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
@Getter
@Setter
public class Student {

  @Id
  private long id;

  private String firstName;

  private String lastName;

  private String email;

  private Address address;

  private String dob;

  private String phoneNumber;

}
