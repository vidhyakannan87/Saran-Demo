package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Employee;
import com.example.Saran.Demo.Repository.EmployeeRepository;
import com.example.Saran.Demo.Service.EmployeeService;
import com.example.Saran.Demo.Service.StripeService;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.BadRequestException;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final StripeService stripeService;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, StripeService stripeService) {
    this.employeeRepository = employeeRepository;
    this.stripeService = stripeService;
  }

  @Override
  public void addAnEmployee(Employee employee) {
    employeeRepository.insert(employee);

  }

  @Override
  public Employee getAnEmployee(long id) {
    Optional<Employee> employeeOptional = Optional.ofNullable(employeeRepository.findByEmployeeId(id));
    if (employeeOptional.isPresent()) {
      return employeeOptional.get();
    } else {
      throw new BadRequestException("Invalid Employee Id");
    }
  }

  @Override
  public void addEmployeeSalaryAccount(long employeeId, BankAccountRequest accountRequest) throws StripeException {

    Employee employee = getAnEmployee(employeeId);
    employee.setStripeConnectId(stripeService.createStripeConnectAccount(employee, accountRequest).getId());

    employeeRepository.save(employee);

  }

  @Override
  public void acceptStripeTos(long employeeId, HttpServletRequest request) throws StripeException {
     Employee employee = getAnEmployee(employeeId);

     stripeService.acceptStripeTos(employee.getStripeConnectId(),request);

  }

}
