package com.kodilla.hibernate.invoice;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
  private int id;
  private String number;
  private List<Item> items;

  public Invoice() {
  }

  public Invoice(String number, List<Item> items) {
    this.number = number;
    this.items = items;
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name = "ID", unique = true, nullable = false)
  public int getId() {
    return id;
  }

  @NotNull
  @Column(name = "NUMBER")
  public String getNumber() {
    return number;
  }

  @OneToMany(
      targetEntity = Item.class,
      mappedBy = "invoice",
      cascade = CascadeType.ALL,
      fetch = FetchType.LAZY
  )
  public List<Item> getItems() {
    return items;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
