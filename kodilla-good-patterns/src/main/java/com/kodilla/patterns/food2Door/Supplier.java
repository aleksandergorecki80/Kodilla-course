package com.kodilla.patterns.food2Door;

public abstract class Supplier implements Process {
  protected String name;
  protected String address;
  protected String phoneNumber;

  public Supplier(final String name, final String address, final String phoneNumber) {
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
  }

  public String getContactDetails() {
    return "Name: " + name + "Address: " + address + "Phone number: " + phoneNumber;
  }
}

