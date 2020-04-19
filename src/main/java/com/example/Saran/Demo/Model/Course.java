package com.example.Saran.Demo.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class Course {

  private String courseId;

  private String title;

  private int credits;

}
