package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Employee;
import com.example.Saran.Demo.Model.SalaryMap;
import com.example.Saran.Demo.Repository.EmployeeRepository;
import com.example.Saran.Demo.Service.EmployeeService;
import com.example.Saran.Demo.Service.StripeService;
import com.example.Saran.Demo.Service.TwilioService;
import com.stripe.exception.StripeException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

import static com.example.Saran.Demo.Service.Utility.SmsUtility.SALARY_CREDIT_SMS;

@Service
public class EmployeeServiceImpl implements EmployeeService {

  private final EmployeeRepository employeeRepository;

  private final SalaryMap salaryMap;

  private final StripeService stripeService;

  private final TwilioService twilioService;

  public EmployeeServiceImpl(EmployeeRepository employeeRepository, StripeService stripeService, TwilioService twilioService) {
    this.employeeRepository = employeeRepository;
    this.twilioService = twilioService;
    this.salaryMap = new SalaryMap();
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
    }
    throw new EntityNotFoundException("Invalid Employee Id");
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

    stripeService.acceptStripeTos(employee.getStripeConnectId(), request);

  }

  @Override
  public void transferEmployeeSalary(long employeeId) throws StripeException {
    Employee employee = getAnEmployee(employeeId);
    double salary = salaryMap.getSalaryMap().get(employee.getSalaryGrade());
    String salarySms = String.format(SALARY_CREDIT_SMS, employee.getFirstName(), salary, LocalDateTime.now().getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH));
    stripeService.transferEmployeeSalary(employee, salary);
    twilioService.sendSMS(employee.getPhoneNumber(), salarySms);


  }

}
