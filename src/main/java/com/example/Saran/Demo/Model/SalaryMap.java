package com.example.Saran.Demo.Model;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SalaryMap {

  private Map<Integer, Double> salaryMap;

  public SalaryMap() {
    this.salaryMap = new HashMap<>();
    salaryMap.put(1, 150d);
    salaryMap.put(2, 200d);
    salaryMap.put(3, 250d);
    salaryMap.put(4, 300d);
    salaryMap.put(5, 350d);
  }
}
