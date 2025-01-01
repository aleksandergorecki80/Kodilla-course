package com.kodilla.patterns.factory.tasks;

public class ShoppingTask extends BaseTask {
  private final String whatToBuy;
  private final double quantity;

  public ShoppingTask(final String taskName, final String whatToBuy, final double quantity) {
    super(taskName);
    this.whatToBuy = whatToBuy;
    this.quantity = quantity;
  }
}
