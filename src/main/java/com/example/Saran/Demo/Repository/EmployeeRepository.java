package com.example.Saran.Demo.Repository;

import com.example.Saran.Demo.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

  Employee findByEmployeeId(long id);
}
