package com.example.Saran.Demo.Service;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Employee;
import com.example.Saran.Demo.Model.Student;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Token;

import javax.servlet.http.HttpServletRequest;

public interface StripeService {

  void createStripeCharge(double amount, String stripeToken, Student student) throws StripeException;

  Token createBankAccount(Employee employee, BankAccountRequest bankAccountRequest) throws StripeException;

  Account createStripeConnectAccount(Employee employee, BankAccountRequest bankAccountRequest) throws StripeException;

  void acceptStripeTos(String accountId, HttpServletRequest request) throws StripeException;

}
