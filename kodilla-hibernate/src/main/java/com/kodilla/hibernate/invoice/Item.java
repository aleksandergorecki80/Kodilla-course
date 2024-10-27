package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "ITEMS")
public class Item {
  private int id;
  private Product product;
  private int quantity;
  private BigDecimal price;
  private BigDecimal value;
  private Invoice invoice;

  public Item() {
  }

  public Item(Product product, BigDecimal price, int quantity, BigDecimal value, Invoice invoice) {
    this.product = product;
    this.price = price;
    this.quantity = quantity;
    this.value = value;
    this.invoice = invoice;
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name = "ID", unique = true)
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "PRICE")
  public BigDecimal getPrice() {
    return price;
  }

  @NotNull
  @Column(name = "QUANTITY")
  public int getQuantity() {
    return quantity;
  }

  @NotNull
  @Column(name = "VALUE")
  public BigDecimal getValue() {
    return value;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  @ManyToOne
  @JoinColumn(name = "PRODUCT_ID")
  public Product getProduct() {
    return product;
  }

  public void setProduct(final Product product) {
    this.product = product;
  }

  @ManyToOne
  @JoinColumn(name = "INVOICE_ID")
  public Invoice getInvoice() {
    return invoice;
  }

  public void setInvoice(final Invoice invoice) {
    this.invoice = invoice;
  }
}
