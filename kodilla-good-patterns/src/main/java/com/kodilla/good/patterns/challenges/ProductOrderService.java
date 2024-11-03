package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {

  @Override
  public boolean addOrder(final OrderRequest orderRequest) {
    System.out.println("Adding order: " + orderRequest.getProduct().getProductName());
    return true;
  }
}
