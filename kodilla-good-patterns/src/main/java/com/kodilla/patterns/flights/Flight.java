package com.kodilla.patterns.flights;

import java.util.Objects;

public class Flight {
  public final String departureAirport;
  public final String arrivalAirport;

  public Flight(final String departureAirport, final String arrivalAirport) {
    this.departureAirport = departureAirport;
    this.arrivalAirport = arrivalAirport;
  }

  public String getDepartureAirport() {
    return departureAirport;
  }

  public String getArrivalAirport() {
    return arrivalAirport;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Flight flight = (Flight) o;
    return Objects.equals(departureAirport, flight.departureAirport) && Objects.equals(arrivalAirport, flight.arrivalAirport);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(departureAirport);
    result = 31 * result + Objects.hashCode(arrivalAirport);
    return result;
  }
}
