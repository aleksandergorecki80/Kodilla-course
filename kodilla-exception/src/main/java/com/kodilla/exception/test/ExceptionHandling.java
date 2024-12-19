package com.kodilla.exception.test;

public class ExceptionHandling {
  private final SecondChallenge secondChallenge = new SecondChallenge();
  public String checkTwoNumbers(double x, double y) throws Exception {
    String result = "";
    try {
      result = secondChallenge.probablyIWillThrowException(x, y);
    } catch (Exception e) {
      throw new Exception();
    } finally {
      System.out.println("Operation is done...");
    }
    return result;
  }
}
