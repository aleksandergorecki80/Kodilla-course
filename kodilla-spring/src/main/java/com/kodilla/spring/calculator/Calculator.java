package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {
  private final Display display;

  @Autowired
  public Calculator(final Display display) {
    this.display = display;
  }

  private double processResult(final double result) {
    this.display.displayValue(result);
    return result;
  }

  public double add(double x, double y) {
    return processResult(x + y);
  }

  public double sub(double x, double y) {
    return processResult(x - y);
  }

  public double mul(double x, double y) {
    return processResult(x * y);
  }

  public double div(double x, double y) {
    return processResult(x / y);
  }

}
