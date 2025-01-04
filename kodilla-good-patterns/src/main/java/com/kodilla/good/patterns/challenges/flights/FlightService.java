package com.kodilla.good.patterns.challenges.flights;

import java.util.Set;
import java.util.stream.Collectors;

public class FlightService {
    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public Set<Flight> findFlightsFrom(String departure) {
        return repository.getFlights().stream()
                .filter(flight -> flight.departureAirport.equals(departure))
                .collect(Collectors.toSet());
    }

    public Set<Flight> findFlightsTo(String arrival) {
        return repository.getFlights()
                .stream()
                .filter(flight -> flight.getArrivalAirport().equals(arrival))
                .collect(Collectors.toSet());
    }
}
