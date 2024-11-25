package com.kodilla.patterns.flights;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {
  private final FlightRepository repository;

  public FlightService(final FlightRepository repository) {
    this.repository = repository;
  }

  public Set<Flight> findFlightsFrom(String departure) {
    return repository.getFlights().stream()
        .filter(flight -> flight.departureAirport.equals(departure))
        .collect(Collectors.toSet());
  }
}
