package com.kodilla.patterns.carrental;

import java.time.LocalDateTime;

public class CarRentalRepository implements RentalRepository {
  @Override
  public boolean createRental(final User user, final LocalDateTime from, final LocalDateTime to) {
    return false;
  }
}
