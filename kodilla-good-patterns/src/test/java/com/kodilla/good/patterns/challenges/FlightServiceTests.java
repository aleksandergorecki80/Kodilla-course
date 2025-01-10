package com.kodilla.good.patterns.challenges;

import com.kodilla.good.patterns.challenges.flights.Flight;
import com.kodilla.good.patterns.challenges.flights.FlightPair;
import com.kodilla.good.patterns.challenges.flights.FlightRepository;
import com.kodilla.good.patterns.challenges.flights.FlightService;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTests {

    @Test
    void shouldFindFlightsFrom() {

        // Given
        Flight flight1 = new Flight("London", "New Deli");
        Flight flight2 = new Flight("London", "New York");
        Flight flight3 = new Flight("New Deli", "New York");
        Flight flight4 = new Flight("Paris", "Berlin");

        FlightRepository flightRepository = new FlightRepository();
        flightRepository.addFlight(flight1);
        flightRepository.addFlight(flight2);
        flightRepository.addFlight(flight3);
        flightRepository.addFlight(flight4);

        FlightService flightService = new FlightService(flightRepository);

        // When
        Set<Flight> result = flightService.findFlightsFrom("London");
        System.out.println(result);

        // Then
        assertEquals(2, result.size());
    }

    @Test
    void shouldFindFlightsTo() {

        // Given
        Flight flight1 = new Flight("London", "New Deli");
        Flight flight2 = new Flight("London", "New York");
        Flight flight3 = new Flight("New Deli", "New York");
        Flight flight4 = new Flight("Paris", "Berlin");

        FlightRepository flightRepository = new FlightRepository();
        flightRepository.addFlight(flight1);
        flightRepository.addFlight(flight2);
        flightRepository.addFlight(flight3);
        flightRepository.addFlight(flight4);

        FlightService flightService = new FlightService(flightRepository);

        // When
        Set<Flight> result = flightService.findFlightsTo("New York");
        System.out.println(result);

        // Then
        assertEquals(2, result.size());
    }

    @Test
    void shouldFindConnectingFlights() {
        // Given
        Flight flight1 = new Flight("London", "Paris");
        Flight flight2 = new Flight("London", "New York");
        Flight flight3 = new Flight("New Deli", "New York");
        Flight flight4 = new Flight("Paris", "Berlin");
        Flight flight5 = new Flight("New York", "Berlin");

        FlightRepository flightRepository = new FlightRepository();
        flightRepository.addFlight(flight1);
        flightRepository.addFlight(flight2);
        flightRepository.addFlight(flight3);
        flightRepository.addFlight(flight4);
        flightRepository.addFlight(flight5);

        FlightService flightService = new FlightService(flightRepository);

        // When
        FlightPair flightPairs1 = new FlightPair(flight1, flight4);
        FlightPair flightPairs2 = new FlightPair(flight2, flight5);
        Set<FlightPair> result =  flightService.findConnectingFlights("London", "Berlin");

        // Then
        result.forEach(FlightPair::showInfo);
        assertTrue(result.contains(flightPairs1));
        assertTrue(result.contains(flightPairs2));
    }

}