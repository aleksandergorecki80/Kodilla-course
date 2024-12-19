package com.kodilla.exception.test;

public class FlightFinderRunner {
  public static void main(String[] args) {
    Flight flight = new Flight("London", "Tokyo");
    FlightFinder flightFinder = new FlightFinder();

    try {
      flightFinder.findFlight(flight);
    } catch (RouteNotFoundException e) {
      System.out.println("Can not process route: " + e.getMessage());
    }
  }
}
