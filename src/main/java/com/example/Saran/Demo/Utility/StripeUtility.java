package com.example.Saran.Demo.Utility;

public class StripeUtility {

  public static int convertDollarsToCents(double amount){

    return Double.valueOf(amount * 100) .intValue();

  }
}
