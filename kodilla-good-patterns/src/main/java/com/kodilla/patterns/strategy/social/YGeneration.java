package com.kodilla.patterns.strategy.social;

import java.util.concurrent.Flow;

public non-sealed class YGeneration extends User {
  public YGeneration(final String name) {
    super(name);
    this.publisher = new SnapchatPublisher();
  }
}
