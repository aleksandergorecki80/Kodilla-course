package com.kodilla.patterns.strategy.social;

public class ZGeneration extends User {
public final class ZGeneration extends User {
  public ZGeneration(final String name) {
    super(name);
    this.publisher = new TwitterPublisher();
  }
}
