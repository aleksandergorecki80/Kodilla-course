package com.kodilla.patterns.strategy;

import com.kodilla.patterns.strategy.predictors.ConservativePredictor;

public final class IndividualCustomer extends Customer {
  public IndividualCustomer(final String name) {
    super(name);
    this.buyPredictor = new ConservativePredictor();
  }
}
