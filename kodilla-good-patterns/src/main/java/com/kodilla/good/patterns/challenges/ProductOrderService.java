package com.kodilla.good.patterns.challenges;

public class ProductOrderService implements OrderService {

  @Override
  public boolean addOrder(final OrderRequest orderRequest) {
    String productName = orderRequest.getProduct().getProductName();
    String userFirstName = orderRequest.getUser().getName();
    String userSurname = orderRequest.getUser().getSurname();
    String date = orderRequest.getOrderDate().toString();

    String result = String.format(
        """
           __Adding order__
            Product Name: %s
            User Name: %s 
            Date: %s
           """, productName, userSurname, date
    );

    System.out.println(result);
    return true;
  }
}
