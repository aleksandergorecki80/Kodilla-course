package com.kodilla.patterns.food2Door;

import java.util.ArrayList;
import java.util.List;

public class Order {
  private final List<Item> items;
  private final Supplier supplier;

  public Order(Supplier supplier) {
    this.supplier = supplier;
    this.items = new ArrayList<>();
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public List<Item> getItems() {
    return items;
  }

  public Supplier getSupplier() {
    return supplier;
  }
}
