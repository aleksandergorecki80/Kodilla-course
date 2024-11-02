package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequestRetriever {
  public OrderRequest retrieveOrder() {
    User user = new User("John", "Smith");
    LocalDate date = LocalDate.now();

    return new OrderRequest(user, date);
  }
}
