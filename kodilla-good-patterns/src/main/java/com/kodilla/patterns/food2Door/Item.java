package com.kodilla.patterns.food2Door;

public class Item {
  private String itemName;
  private int quantity;

  public Item(final String itemName, final int quantity) {
    this.itemName = itemName;
    this.quantity = quantity;
  }

  public String getItemName() {
    return itemName;
  }

  public void setItemName(final String itemName) {
    this.itemName = itemName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(final int quantity) {
    this.quantity = quantity;
  }
}
