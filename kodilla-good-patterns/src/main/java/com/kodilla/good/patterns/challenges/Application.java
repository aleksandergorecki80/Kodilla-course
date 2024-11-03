package com.kodilla.good.patterns.challenges;

public class Application {
  public static void main(String[] args) {
    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieveOrder();
    System.out.println(orderRequest);

    OrderProcessor orderProcessor = new OrderProcessor(
        new MailNotification(),
        new ProductOrderService(),
        new ProductOrderRepository()
    );
    orderProcessor.process(orderRequest);
  }
}
