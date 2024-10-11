package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.AggressivePredictor;

public final class IndividualYoungCustomer extends Customer {
  public IndividualYoungCustomer(final String name) {
    super(name);
    this.buyPredictor = new AggressivePredictor();
  }
}
