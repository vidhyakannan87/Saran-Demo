package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;

import java.util.List;

public interface DepartmentService {

  void addADepartment(Department department);

  List<Department> getAll();

  Department findByID(long id);

  Department updateDepartmentByDeptId(Department department, long deptId);

  void deleteByDeptId(long deptId);

  List<Course> getCoursesByDepartmentId(long deptId);
}
