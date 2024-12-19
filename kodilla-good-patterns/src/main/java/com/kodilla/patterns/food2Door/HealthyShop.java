package com.kodilla.patterns.food2Door;

import java.awt.*;
import java.util.List;

public class HealthyShop extends Supplier {
  public HealthyShop(final String name, final String address, final String phoneNumber) {
    super(name, address, phoneNumber);
  }

  @Override
  public boolean process(final Order order) {
    List<Item> items = order.getItems();
    System.out.println("Processing order for " + this.name);

    int totalQuantity = items.stream().mapToInt(Item::getQuantity).sum();

    if (totalQuantity > 50) {
      System.out.println("Free delivery applied!");
    }
    return true;
  }
}
