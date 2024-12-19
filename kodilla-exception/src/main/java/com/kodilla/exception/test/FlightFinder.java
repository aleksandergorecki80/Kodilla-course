package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {
  public boolean findFlight(Flight flight) throws RouteNotFoundException {
    Map<String, Boolean> flightsAvailabilityDetails = new HashMap<>();

    flightsAvailabilityDetails.put("London", true);
    flightsAvailabilityDetails.put("Paris", true);
    flightsAvailabilityDetails.put("New York", true);
    flightsAvailabilityDetails.put("San Francisco", true);
    flightsAvailabilityDetails.put("Berlin", false);

    Boolean isFlightAvailable = flightsAvailabilityDetails.get(flight.getArrivalAirport());

    if (isFlightAvailable == null) {
      throw new RouteNotFoundException("Flight not found");
    }

    return isFlightAvailable;
  }
}
