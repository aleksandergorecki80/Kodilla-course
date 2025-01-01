package com.kodilla.good.patterns.challenges;

import java.time.LocalDate;

public class OrderRequestRetriever {
  public OrderRequest retrieveOrder() {
    User user = new User("John", "Smith");
    Product product = new Product("toothbrush", 200);
    LocalDate date = LocalDate.now();

    return new OrderRequest(user, product, 3, 600, date);
  }
}
