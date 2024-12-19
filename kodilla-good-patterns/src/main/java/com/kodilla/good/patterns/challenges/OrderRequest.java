package com.kodilla.good.patterns.challenges;


import java.time.LocalDate;

public class OrderRequest {
  final private User user;
  final private Product product;
  final private int quantity;
  final private int totalPrice;
  final private LocalDate orderDate;

  public OrderRequest(final User user, final Product product, final int quantity, final int totalPrice, final LocalDate orderDate) {
    this.user = user;
    this.product = product;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
    this.orderDate = orderDate;
  }

  public User getUser() {
    return user;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public LocalDate getOrderDate() {
    return orderDate;
  }
}
