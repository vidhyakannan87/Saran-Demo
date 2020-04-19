package com.example.Saran.Demo.Controller.impl;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Controller.EmployeeController;
import com.example.Saran.Demo.Model.Employee;
import com.example.Saran.Demo.Service.EmployeeService;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class EmployeeControllerImpl implements EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeControllerImpl(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @Override
  public void addAEmployee(@RequestBody Employee employee) {
    employeeService.addAnEmployee(employee);
  }

  @Override
  public Employee getAnEmployee(@PathVariable long id) {
    return employeeService.getAnEmployee(id);
  }

  @Override
  public void addEmployeeSalaryAccount(@PathVariable long id, @RequestBody BankAccountRequest bankAccountRequest) throws StripeException {
    employeeService.addEmployeeSalaryAccount(id, bankAccountRequest);

  }

  @Override
  public void acceptStripeTos(@PathVariable long id, HttpServletRequest request) throws StripeException {
    employeeService.acceptStripeTos(id, request);
  }

  @Override
  public void transferEmployeeSalary(@PathVariable long id) throws StripeException {
    employeeService.transferEmployeeSalary(id);
  }
}
