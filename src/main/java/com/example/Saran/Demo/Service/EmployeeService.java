package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Employee;
import com.stripe.exception.StripeException;

import javax.servlet.http.HttpServletRequest;

public interface EmployeeService {

  void addAnEmployee(Employee employee);

  Employee getAnEmployee(long id);

  void addEmployeeSalaryAccount(long employeeId, BankAccountRequest accountRequest) throws StripeException;

  void acceptStripeTos(long employeeId, HttpServletRequest request) throws StripeException;

  void transferEmployeeSalary(long employeeId) throws StripeException;

}
