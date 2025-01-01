package com.kodilla.patterns.food2Door;

import java.util.List;
import java.util.Optional;

public class GlutenFreeShop extends Supplier {

  public GlutenFreeShop(final String name, final String address, final String phoneNumber) {
    super(name, address, phoneNumber);
  }

  @Override
  public boolean process(final Order order) {
    List<Item> items = order.getItems();
    System.out.println("Processing order for " + this.name);
    Optional<Item> isEagOnList = items
        .stream()
        .filter(item -> item.getItemName().equals("Egg"))
        .findFirst();

    if (isEagOnList.isPresent()) {
      System.out.println("Add extra packaging for fragile item");
    }
    return true;
  }
}
