package com.example.Saran.Demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Student")
@Getter
@Setter
public class Student {

  private String studentId;

  private String firstName;

  private String lastName;

}
