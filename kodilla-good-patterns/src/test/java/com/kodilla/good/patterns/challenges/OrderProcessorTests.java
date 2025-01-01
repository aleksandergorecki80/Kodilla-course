package com.kodilla.good.patterns.challenges;

import com.kodilla.patterns.food2Door.*;
import com.kodilla.patterns.food2Door.OrderProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderProcessorTests {
  @Test
  public void testProcessExtraFoodShop() {
    // Given
    Supplier extraFoodShop = new ExtraFoodShop("ExtraFoodShop", "Warszawa", "555-666-777");
    Item sushi = new Item("Sushi", 10);
    Item tunaFish = new Item("Tuna fish", 5);
    Order extraFoodShopOrder = new Order(extraFoodShop);
    extraFoodShopOrder.addItem(sushi);
    extraFoodShopOrder.addItem(tunaFish);

    // When
    OrderProcessor processor = new OrderProcessor();
    boolean processingResult = processor.processOrder(extraFoodShopOrder);

    // Then
    assertTrue(processingResult);
  }

  @Test
  public void testProcessGlutenFreeShop() {
    // Given
    Supplier glutenFreeShop = new GlutenFreeShop("GlutenFree", "Radom", "999-888-777");
    Item milk = new Item("Milk", 5);
    Item egg = new Item("Egg", 6);
    Item cheese = new Item("Cheese", 8);
    Order glutenFreeShopOrder = new Order(glutenFreeShop);
    glutenFreeShopOrder.addItem(egg);
    glutenFreeShopOrder.addItem(cheese);
    glutenFreeShopOrder.addItem(milk);

    // When
    OrderProcessor processor = new OrderProcessor();
    boolean processingResult = processor.processOrder(glutenFreeShopOrder);

    // Then
    assertTrue(processingResult);
  }

  @Test
  public void testHealthyShop() {
    // Given
    Supplier healthyShop = new HealthyShop("HealthyShop", "Krakow", "111-222-333");
    Item tomato = new Item("Tomato", 40);
    Item salad = new Item("Salad", 6);
    Item cucumber = new Item("Cucumber", 8);
    Order healthyShopOrder = new Order(healthyShop);
    healthyShopOrder.addItem(tomato);
    healthyShopOrder.addItem(salad);
    healthyShopOrder.addItem(cucumber);

    // When
    OrderProcessor processor = new OrderProcessor();
    boolean processingResult = processor.processOrder(healthyShopOrder);

    // Then
    assertTrue(processingResult);
  }
}
