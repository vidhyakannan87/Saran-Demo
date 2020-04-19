package com.example.Saran.Demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
public class Department {

  private String name;

  private double budget;

  private List<Course> course=new ArrayList<>();

}
