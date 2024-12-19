package com.kodilla.stream.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayOperationsTests {
  @Test
  void testGetAverage() {
    // Given
    int[] numbers = {3, 11, 15, 22, 25, 8};

    // When
    double average = ArrayOperations.getAverage(numbers);

    // Then
    assertEquals(14, average);
  }
}
