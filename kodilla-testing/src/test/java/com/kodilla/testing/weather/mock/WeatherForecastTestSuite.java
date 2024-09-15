package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {
  @Mock
  private Temperatures temperaturesMock;

  @Test
  void testCalculateForecastWithMock() {
    // Given
    Map<String, Double> temperaturesMap = new HashMap<>();
    temperaturesMap.put("Rzeszow", 25.5);
    temperaturesMap.put("Krakow", 26.2);
    temperaturesMap.put("Wroclaw", 24.8);
    temperaturesMap.put("Warszawa", 25.2);
    temperaturesMap.put("Gdansk", 26.1);

    when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    WeatherForecast weatherForecastMock = new WeatherForecast(temperaturesMock);

    // When
    int quantityOfSensors = weatherForecastMock.calculateForecast().size();

    // Then
    Assertions.assertEquals(5, quantityOfSensors);
  }

  @Test
  void testCalculateAverageTemperature() {
    // Given
    Map<String, Double> temperaturesMap = new HashMap<>();
    temperaturesMap.put("Rzeszow", 19.5);
    temperaturesMap.put("Krakow", 26.2);
    temperaturesMap.put("Wroclaw", 21.8);
    temperaturesMap.put("Warszawa", 25.2);
    temperaturesMap.put("Gdansk", 30.1);

    when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    WeatherForecast weatherForecastMock = new WeatherForecast(temperaturesMock);

    // When
    double averageTemperature = weatherForecastMock.calculateAverageTemperature();

    // Then
    Assertions.assertEquals(24.56, averageTemperature);
  }


  @DisplayName(
      "When given the map with an odd number of entries, " +
          "then the median temperature should be returned."
  )
  @Test
  void calculateMedianTemperatureFromOddEntries() {
    // Given
    Map<String, Double> temperaturesMap = new HashMap<>();
    temperaturesMap.put("Rzeszow", 19.5);
    temperaturesMap.put("Krakow", 26.2);
    temperaturesMap.put("Wroclaw", 21.8);
    temperaturesMap.put("Warszawa", 25.2);
    temperaturesMap.put("Gdansk", 30.1);

    when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    WeatherForecast weatherForecastMock = new WeatherForecast(temperaturesMock);

    // When
    double result = weatherForecastMock.calculateMedianTemperature();

    // Then
    Assertions.assertEquals(25.2, result);
  }

  @DisplayName(
      "When given the map with an odd number of entries, " +
          "then the median temperature should be returned."
  )
  @Test
  void calculateMedianTemperatureFromEvenEntries() {
    // Given
    Map<String, Double> temperaturesMap = new HashMap<>();
    temperaturesMap.put("Rzeszow", 19.5);
    temperaturesMap.put("Krakow", 26.2);
    temperaturesMap.put("Wroclaw", 21.8);
    temperaturesMap.put("Warszawa", 25.2);

    when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
    WeatherForecast weatherForecastMock = new WeatherForecast(temperaturesMock);

    // When
    double result = weatherForecastMock.calculateMedianTemperature();

    // Then
    Assertions.assertEquals(23.5, result);
  }
}
