package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderRequest {
  private final User user;
  private final LocalDate orderDate;

  public OrderRequest(final User user, final LocalDate orderDate) {
    this.user = user;
    this.orderDate = orderDate;
  }

  public User getUser() {
    return user;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }
}
