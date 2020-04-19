package com.example.Saran.Demo.Repository;

import com.example.Saran.Demo.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends MongoRepository<Course, String> {
    List<Course> getCoursesByDepartmentName(String depName);
}
