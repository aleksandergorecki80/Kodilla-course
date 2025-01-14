package com.kodilla.exception.test;

public final class FlightBuilder {
  private String departureAirport;
  private String arrivalAirport;

  private FlightBuilder() {
  }

  public static FlightBuilder aFlight() {
    return new FlightBuilder();
  }

  public FlightBuilder withDepartureAirport(String departureAirport) {
    this.departureAirport = departureAirport;
    return this;
  }

  public FlightBuilder withArrivalAirport(String arrivalAirport) {
    this.arrivalAirport = arrivalAirport;
    return this;
  }

  public Flight build() {

    return new Flight(departureAirport, arrivalAirport);
  }
}


