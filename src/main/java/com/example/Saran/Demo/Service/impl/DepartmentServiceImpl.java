package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import com.example.Saran.Demo.Repository.DepartmentRepository;
import com.example.Saran.Demo.Service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
    this.departmentRepository = departmentRepository;
  }

  @Override
  public void addADepartment(Department department) {

    departmentRepository.insert(department);

  }

  @Override
  public Department getADepartment(long id) {
    Optional<Department> departmentOptional = departmentRepository.findById(id);
    if (departmentOptional.isPresent()) {
      return departmentOptional.get();
    }
    throw new EntityNotFoundException("Invalid Department Id");
  }

  @Override
  public List<Course> getCoursesByDepartmentId(long id) {

    return getADepartment(id).getCourseList();
  }
}
