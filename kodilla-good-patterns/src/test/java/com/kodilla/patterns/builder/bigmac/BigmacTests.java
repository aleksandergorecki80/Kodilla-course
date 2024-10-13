package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTests {
  @Test
  void testBigMac() {
    // Given
    Bigmac bigmac = new Bigmac.BigmacBuilder()
        .bun(BunType.PLAIN)
        .ingredient("onion")
        .burgers(2)
        .ingredient("cheese")
        .sauce("barbecue")
        .ingredient("pickle")
        .build();
    System.out.println(bigmac);

    // When
    BunType bun = bigmac.getBun();
    int howManyBurgers = bigmac.getBurgers();
    String souse = bigmac.getSauce();
    int howManyIngredients = bigmac.getIngredients().size();

    // Then
    assertEquals(BunType.PLAIN, bun);
    assertEquals(2, howManyBurgers);
    assertEquals("barbecue", souse);
    assertEquals(3, howManyIngredients);
  }
}
