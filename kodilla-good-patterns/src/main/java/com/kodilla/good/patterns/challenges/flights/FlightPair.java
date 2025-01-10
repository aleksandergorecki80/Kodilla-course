package com.kodilla.good.patterns.challenges.flights;

import java.util.Objects;

public class FlightPair {
    private final Flight firstFlight;
    private final Flight secondFlight;

    public FlightPair(Flight firstFlight, Flight secondFlight) {
        this.firstFlight = firstFlight;
        this.secondFlight = secondFlight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FlightPair that = (FlightPair) o;
        return Objects.equals(firstFlight, that.firstFlight) && Objects.equals(secondFlight, that.secondFlight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstFlight, secondFlight);
    }


    public void showInfo() {
        System.out.println("--------");
        System.out.println(firstFlight.getDepartureAirport() + " -> " + firstFlight.getArrivalAirport());
        System.out.println(secondFlight.getDepartureAirport() + " -> " + secondFlight.getArrivalAirport());
    }
}

