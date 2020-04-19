package com.example.Saran.Demo.Controller;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Employee;
import com.stripe.exception.StripeException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/employee")
public interface EmployeeController {

  @PostMapping
  void addAEmployee(@RequestBody Employee employee);

  @GetMapping("/{id}")
  Employee getAnEmployee(@PathVariable long id);

  @PostMapping("/{id}")
  void addEmployeeSalaryAccount(@PathVariable long id, @RequestBody BankAccountRequest bankAccountRequest) throws StripeException;

  @PatchMapping("/{id}/acceptStripeTos")
  void acceptStripeTos(@PathVariable long id, HttpServletRequest request) throws StripeException;

  @PostMapping("/{id}/salary")
  void transferEmployeeSalary(@PathVariable long id) throws StripeException;

}
