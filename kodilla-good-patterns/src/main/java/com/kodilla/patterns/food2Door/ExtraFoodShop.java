package com.kodilla.patterns.food2Door;

import java.util.List;

public class ExtraFoodShop extends Supplier {
  public ExtraFoodShop(final String name, final String address, final String phoneNumber) {
    super(name, address, phoneNumber);
  }

  @Override
  public boolean process(final Order order) {
    List<Item> items = order.getItems();
    System.out.println("Processing order for " + this.name);
    for (Item item : items) {
      System.out.println(item.getItemName() + " - " + item.getQuantity() );
    }
    return true;
  }
}
