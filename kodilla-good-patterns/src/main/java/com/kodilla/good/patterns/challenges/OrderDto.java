package com.kodilla.good.patterns.challenges;

public class OrderDto {
  private final User user;
  private final boolean isOrderPlaced;

  public OrderDto(final User user, final boolean isOrderPlaced) {
    this.user = user;
    this.isOrderPlaced = isOrderPlaced;
  }

  public User getUser() {
    return user;
  }

  public boolean isOrderPlaced() {
    return isOrderPlaced;
  }
}
