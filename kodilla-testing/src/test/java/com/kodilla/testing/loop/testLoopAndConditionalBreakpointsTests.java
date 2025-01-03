package com.kodilla.testing.loop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testLoopAndConditionalBreakpointsTests {
  @Test
  public void testLoop() {
    // Given
    long sum = 0;

    // When
    for (int i = 0; i < 1000; i++) {
      sum += i;
      System.out.println("[" + i + "] " + sum);
    }

    // Then
    assertEquals(499500, sum);
  }
}
