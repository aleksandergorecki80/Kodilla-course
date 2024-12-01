package com.kodilla.patterns.flights;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {
  private final FlightRepository repository;

  public FlightService(FlightRepository repository) {
    this.repository = repository;
  }

  public Set<Flight> findFlightsFrom(String departure) {
    return repository.getFlights().stream()
        .filter(flight -> flight.getDepartureAirport().equals(departure))
        .collect(Collectors.toSet());
  }

  public Set<Flight> findFlightsTo(String arrival) {
    return repository.getFlights()
        .stream()
        .filter(flight -> flight.getArrivalAirport().equals(arrival))
        .collect(Collectors.toSet());
  }
}
