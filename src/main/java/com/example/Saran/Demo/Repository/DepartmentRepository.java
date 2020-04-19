package com.example.Saran.Demo.Repository;

import com.example.Saran.Demo.Model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
//This was the main error You had this as
//public interface DepartmentRepository extends MongoRepository<Course, String> {
//which should have been MongoRepository<Department, String>
public interface DepartmentRepository extends MongoRepository<Department, String> {

  Department findById(long id);

}
