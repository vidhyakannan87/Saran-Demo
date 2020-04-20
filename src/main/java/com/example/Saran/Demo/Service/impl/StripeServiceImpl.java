package com.example.Saran.Demo.Service.impl;

import com.example.Saran.Demo.API.Request.BankAccountRequest;
import com.example.Saran.Demo.Model.Address;
import com.example.Saran.Demo.Model.Employee;
import com.example.Saran.Demo.Model.Student;
import com.example.Saran.Demo.Service.StripeService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Account;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.model.Transfer;
import com.stripe.param.AccountUpdateParams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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

  @Override
  public void transferEmployeeSalary(Employee employee, double salary) throws StripeException {
    Map<String, Object> params = createSalaryTransferMap(employee, salary);

    Transfer.create(params);

  }


  private Map<String, Object> createStripeChargeParams(double amount, String token, Student student) {

    String description = "Fee Payment for current Semester by Student id: " + student.getId();

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
    params.put("business_type", "individual");
    params.put("individual", createIndividualMap(employee));
    params.put("external_account", token.getId());

    return params;
  }


  private Map<String, Object> createIndividualMap(Employee employee) {
    Map<String, Object> params = new HashMap<>();
    params.put("email", employee.getPersonalEmail());
    params.put("first_name", employee.getFirstName());
    params.put("id_number", employee.getSsn());
    params.put("last_name", employee.getLastName());
    params.put("dob", createDobMap(employee));
    params.put("address", createAddressMap(employee.getAddress()));
    params.put("phone", employee.getPhoneNumber());

    return params;

  }

  private Map<String, Object> createDobMap(Employee employee) {
    LocalDate dob = LocalDate.parse(employee.getDob());
    Map<String, Object> params = new HashMap<>();
    params.put("day", dob.getDayOfMonth());
    params.put("month", dob.getMonthValue());
    params.put("year", dob.getYear());

    return params;
  }

  private Map<String, Object> createAddressMap(Address employeeAddress) {
    Map<String, Object> address = new HashMap<>();
    address.put("city", employeeAddress.getCity());
    address.put("line1", employeeAddress.getLine1());
    address.put("postal_code", employeeAddress.getPostalCode());
    address.put("state", employeeAddress.getState());

    return address;
  }

  private Map<String, Object> createSalaryTransferMap(Employee employee, double salary) {
    LocalDate date = LocalDate.now();
    String transferGroup = "SALARY" + date.getMonthValue() + "/" + date.getYear();
    Map<String, Object> params = new HashMap<>();
    params.put("amount", convertDollarsToCents(salary));
    params.put("currency", "usd");
    params.put("destination", employee.getStripeConnectId());
    params.put("transfer_group", transferGroup);

    return params;

  }


}
