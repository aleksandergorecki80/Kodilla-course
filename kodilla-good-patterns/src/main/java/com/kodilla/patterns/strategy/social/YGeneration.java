package com.kodilla.patterns.strategy.social;

import java.util.concurrent.Flow;

public final class YGeneration extends User {
  public YGeneration(final String name) {
    super(name);
    this.publisher = new SnapchatPublisher();
  }
}
