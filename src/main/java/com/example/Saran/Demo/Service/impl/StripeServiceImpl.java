package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Employee;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Service.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.AccountUpdateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.Saran.Demo.Utility.StripeUtility.convertDollarsToCents;

@Service
public class StripeServiceImpl implements StripeService {

  @Value("${stripe.apiKey}")
  private String stripeAPIKey;


  @PostConstruct
  public void init() {
    Stripe.apiKey = stripeAPIKey;
  }

  @Override
  public void createStripeCharge(double amount, String stripeToken, Student student) throws StripeException {

    Map<String, Object> params = createStripeChargeParams(amount, stripeToken, student);

    Charge.create(params);


  }

  @Override
  public Token createBankAccount(Employee employee, BankAccountRequest bankAccountRequest) throws StripeException {
    Map<String, Object> params = new HashMap<>();

    params.put("bank_account", createBankAccountMap(employee, bankAccountRequest));
    return Token.create(params);

  }

  @Override
  public Account createStripeConnectAccount(Employee employee, BankAccountRequest bankAccountRequest) throws StripeException {

    Token token = createBankAccount(employee, bankAccountRequest);

    return Account.create(createAccountMap(employee, token));

  }

  @Override
  public void acceptStripeTos(String accountId, HttpServletRequest request) throws StripeException {
     Account account = Account.retrieve(accountId);

    AccountUpdateParams params = AccountUpdateParams.builder().setTosAcceptance(
                            AccountUpdateParams.TosAcceptance.builder()
                                    .setDate((long) System.currentTimeMillis() / 1000L)
                                    .setIp(request.getRemoteAddr()) // Assumes you're not using a proxy
                                    .build()).build();

     account.update(params);
  }


  private Map<String, Object> createStripeChargeParams(double amount, String token, Student student) {

    String description = "Fee Payment for current Semester by Student id: " + student.getStudentId();

    Map<String, Object> chargeParams = new HashMap<>();
    chargeParams.put("amount", convertDollarsToCents(amount));
    chargeParams.put("currency", "usd");
    chargeParams.put("source", token);
    chargeParams.put("description", description);
    return chargeParams;

  }


  private Map<String, Object> createBankAccountMap(Employee employee, BankAccountRequest bankAccountRequest) {

    Map<String, Object> bankAccount = new HashMap<>();

    String employeeName = employee.getFirstName() + " " + employee.getLastName();

    bankAccount.put("country", "US");
    bankAccount.put("currency", "usd");
    bankAccount.put("account_holder_name", employeeName);
    bankAccount.put("account_holder_type", "individual");
    bankAccount.put("routing_number", bankAccountRequest.getRoutingNumber());
    bankAccount.put("account_number", bankAccountRequest.getAccountNumber());

    return bankAccount;

  }


  private Map<String, Object> createAccountMap(Employee employee, Token token) {

    List<Object> requestedCapabilities = new ArrayList<>();
    requestedCapabilities.add("card_payments");
    requestedCapabilities.add("transfers");
    Map<String, Object> params = new HashMap<>();
    params.put("type", "custom");
    params.put("country", "US");
    params.put("email", employee.getPersonalEmail());
    params.put("requested_capabilities", requestedCapabilities);
    params.put("external_account", token.getId());

    return params;
  }


}
