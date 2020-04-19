package com.example.Saran.Demo.API.Request;

import lombok.Data;

@Data
public class BankAccountRequest {

  private String routingNumber;

  private String accountNumber;
}
