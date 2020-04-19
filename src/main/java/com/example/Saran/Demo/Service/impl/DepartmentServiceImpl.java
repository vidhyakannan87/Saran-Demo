package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.Model.Course;
import com.example.Saran.Demo.Model.Department;
import com.example.Saran.Demo.Repository.DepartmentRepository;
import com.example.Saran.Demo.Service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void addADepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Course> getCoursesByDepartmentName(String deptName) {
        return departmentRepository.getCoursesByDepartmentName(deptName);
    }
}
