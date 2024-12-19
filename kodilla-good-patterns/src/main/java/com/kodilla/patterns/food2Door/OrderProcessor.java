package com.kodilla.patterns.food2Door;

public class OrderProcessor {

  public boolean processOrder(Order order) {
    Supplier supplier = order.getSupplier();
    boolean isSuccessful = supplier.process(order);
    if (isSuccessful) {
      System.out.println("Order processed successfully for " + order.getSupplier().getClass().getSimpleName());
      return true;
    } else {
      System.out.println("Order processing failed for " + order.getSupplier().getClass().getSimpleName());
      return false;
    }
  }
}

