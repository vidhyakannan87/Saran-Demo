package com.example.Saran.Demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Getter
@Setter
public class Department {

  @Id
  private long id;

  private String name;

  private double budget;

  private List<Course> courseList;

}
