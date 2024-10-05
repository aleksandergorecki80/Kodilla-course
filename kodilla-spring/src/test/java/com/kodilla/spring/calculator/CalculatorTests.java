package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CalculatorTests {
  @Autowired
  public Calculator calculator;

  @Test
  void testCalculations() {
    // Given
    // When
    double addingResult = calculator.add(3, 2);
    double subtractingResult = calculator.sub(13, 5);
    double multiplicationResult = calculator.mul(7, 5);
    double divisionResult = calculator.div(13, 5);

    // Then
    assertEquals(5, addingResult);
    assertEquals(8, subtractingResult);
    assertEquals(35, multiplicationResult);
    assertEquals(2.6, divisionResult);
  }
}
