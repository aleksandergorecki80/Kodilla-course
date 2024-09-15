package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {
  private Temperatures temperatures;

  public WeatherForecast(Temperatures temperatures) {
    this.temperatures = temperatures;
  }

  public Map<String, Double> calculateForecast() {
    Map<String, Double> resultMap = new HashMap<>();

    for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
      resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
    }
    return resultMap;
  };

  public double calculateAverageTemperature() {
    double sum = 0;
    for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
      sum += temperature.getValue();
    }
    return sum / temperatures.getTemperatures().size();
  };

  public double calculateMedianTemperature() {
    List<Double> valuesOfTemperatures = new ArrayList<>();
    for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
      valuesOfTemperatures.add(temperature.getValue());
    }

    Collections.sort(valuesOfTemperatures);
    boolean isEven = valuesOfTemperatures.size() % 2 == 0;
    double median;

    if (isEven) {
      int firstElementPosition = valuesOfTemperatures.size() / 2;
      int secondElementPosition = firstElementPosition - 1;

      median = (valuesOfTemperatures.get(firstElementPosition)
          + valuesOfTemperatures.get(secondElementPosition)) / 2 ;
    } else {
      median = valuesOfTemperatures.get((valuesOfTemperatures.size() + 1) / 2) - 1;
    }
    return median;
  };
}
