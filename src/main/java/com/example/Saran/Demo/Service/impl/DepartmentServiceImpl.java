package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import com.example.Saran.Demo.Repository.DepartmentRepository;
import com.example.Saran.Demo.Service.DepartmentService;
import org.springframework.stereotype.Service;

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
  public Department updateDepartmentByDeptId(Department department, long deptId) {
    Optional<Department> oldDepartment = departmentRepository.findById(deptId);
    if (oldDepartment.isPresent()) {
      Department tempDepartment = oldDepartment.get();
      tempDepartment = department;
      tempDepartment.setId(deptId);
      departmentRepository.save(tempDepartment);
      return tempDepartment;
    }
    department.setId(deptId);
    departmentRepository.insert(department);
    return department;
  }

  @Override
  public void deleteByDeptId(long deptId) {
    Department department = findByID(deptId);
    if (department != null) {
      departmentRepository.delete(department);
    }
  }


  @Override
  public Department findByID(long deptId) {
    Optional<Department> departmentOptional  = departmentRepository.findById(deptId);
    if (departmentOptional.isPresent()) {
      return departmentOptional.get();
    }
    return null;
  }


  @Override
  public List<Course> getCoursesByDepartmentId(long id) {
    Department department = findByID(id);
    return department.getCourseList();
  }


}
