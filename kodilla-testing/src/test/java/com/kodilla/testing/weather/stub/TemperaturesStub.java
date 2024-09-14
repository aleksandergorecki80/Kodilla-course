package com.kodilla.testing.weather.stub;

import java.util.HashMap;
import java.util.Map;

public class TemperaturesStub implements Temperatures{

  @Override
  public Map<String, Double> getTemperatures() {
    Map<String, Double> stubResults = new HashMap<>();

    // dummy data
    stubResults.put("Krakow", 25.5);
    stubResults.put("Rzeszów", 32.0);
    stubResults.put("Wrocław", 29.0);
    stubResults.put("Warszawa", 25.2);
    stubResults.put("Gdańsk", 26.7);
    return stubResults;
  }
}
