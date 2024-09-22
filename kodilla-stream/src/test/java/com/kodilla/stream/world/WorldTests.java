package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorldTests {
  @Test
  public void testGetPeopleQuantity() {
    // Given
    List<Country> countriesOfEurope = List.of(
    new Country("Turkey", new BigDecimal("85816199")),
    new Country("Germany", new BigDecimal("83294633")),
    new Country("United Kingdom", new BigDecimal("67736802")),
    new Country("France", new BigDecimal("64756584"))
    );
    Continent europe = new Continent("Europe", countriesOfEurope);

    List<Country> countriesOfAfrica = List.of(
        new Country("Gabon", new BigDecimal("2484789")),
        new Country("Botswana", new BigDecimal("2480244")),
        new Country("Eritrea", new BigDecimal("3470390")),
        new Country("Libya", new BigDecimal("7305659"))
    );
    Continent africa = new Continent("Africa", countriesOfAfrica);

    List<Country> countriesOfAsia = List.of(
        new Country("Kuwait", new BigDecimal("4310108")),
        new Country("Georgia", new BigDecimal("3728282")),
        new Country("Mongolia", new BigDecimal("3447157")),
        new Country("Singapore", new BigDecimal("6014723"))
    );
    Continent asia = new Continent("Asia", countriesOfAsia);

    // When
    World world = new World(List.of(europe, africa, asia));

    // Then
    BigDecimal expected = new BigDecimal("334845570");
    assertEquals(expected, world.getPeopleQuantity());
  }
}
