package com.example.Saran.Demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@Data
public class Student {
    @Id
    @JsonIgnore
    private int studentId;

    private String firstName;

    private String lastName;

}
