package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.Model.Department;
import com.example.Saran.Demo.Repository.DepartmentRepository;
import com.example.Saran.Demo.Service.impl.DepartmentServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.example.Saran.Demo.Service.Utility.CreateTestObjects.createTestDepartment;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DepartmentTest {

  private DepartmentServiceImpl departmentServiceImpl;
  private DepartmentRepository departmentRepository;

  @Before
  public void setup() {

    this.departmentRepository = mock(DepartmentRepository.class);
    this.departmentServiceImpl = new DepartmentServiceImpl(departmentRepository);
  }

  @Test
  public void getAllDepartmentTest() {
    Department testDepartment = createTestDepartment();
    List<Department> departmentList = new ArrayList<>();

    departmentList.add(testDepartment);

    when(departmentRepository.findAll()).thenReturn(departmentList);
    assertEquals(departmentServiceImpl.getAll().size(), departmentList.size());


  }


}
