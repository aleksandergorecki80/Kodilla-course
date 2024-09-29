package com.kodilla.patterns.carrental;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface RentalRepository {
  boolean createRental(User user, LocalDateTime from, LocalDateTime to);
}
