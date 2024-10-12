package com.kodilla.patterns.strategy.social;

public class Millenials extends User {
  public Millenials(final String name) {
    super(name);
    this.publisher = new FacebookPublisher();
  }
}
