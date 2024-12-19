package com.kodilla.good.patterns.challenges;

public class ProductOrderRepository implements OrderRepository {
  @Override
  public boolean createOrder(final OrderRequest orderRequest) {
    String productName = orderRequest.getProduct().getProductName();
    int productPrice = orderRequest.getProduct().getProductPrice();

    String line = String.format(""" 
        Saving order:
          Product name: %s
          Product price: %s
        """, productName, productPrice);

    System.out.println(line);
    return true;
  }
}
