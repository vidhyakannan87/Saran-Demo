package com.example.Saran.Demo.Repository;

import com.example.Saran.Demo.Model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
