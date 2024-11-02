package com.kodilla.good.patterns.challenges;

public class Application {
  public static void main(String[] args) {
    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieveOrder();
    System.out.println(orderRequest);



  }
}
