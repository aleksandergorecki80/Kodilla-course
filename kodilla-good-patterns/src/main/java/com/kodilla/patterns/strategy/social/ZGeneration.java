package com.kodilla.patterns.strategy.social;

public non-sealed class ZGeneration extends User {
  public ZGeneration(final String name) {
    super(name);
    this.publisher = new TwitterPublisher();
  }
}
