package com.kodilla.good.patterns.challenges;

public class Product {
  final private String productName;
  final private int productPrice;

  public Product(final String productName, final int productPrice) {
    this.productName = productName;
    this.productPrice = productPrice;
  }

  public String getProductName() {
    return productName;
  }

  public int getProductPrice() {
    return productPrice;
  }
}
