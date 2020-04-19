package com.example.Saran.Demo.API.Request;

import lombok.Data;

@Data
public class StripeChargeRequest {

  private String stripeToken;

  private double amount;

}
