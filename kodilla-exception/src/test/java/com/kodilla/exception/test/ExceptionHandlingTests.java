package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReaderException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTests {
  @Test
  public void testExceptionHandlingThrowsOrNot() throws Exception {
    // Given
    ExceptionHandling exceptionHandling = new ExceptionHandling();

    // When & Then
    assertAll(
        () -> assertThrows(Exception.class, () -> exceptionHandling.checkTwoNumbers(3, 10)),
        () -> assertThrows(Exception.class, () -> exceptionHandling.checkTwoNumbers(2, 10)),
        () -> assertThrows(Exception.class, () -> exceptionHandling.checkTwoNumbers(-1, 10)),
        () -> assertThrows(Exception.class, () -> exceptionHandling.checkTwoNumbers(1.6, 1.5)),
        () -> assertDoesNotThrow(() -> exceptionHandling.checkTwoNumbers(1, 1))
    );
  }

  @Test
  public void testExceptionHandlingReturns() throws Exception {
    // Given
    ExceptionHandling exceptionHandling = new ExceptionHandling();

    // When & Then
    String result = exceptionHandling.checkTwoNumbers(1, 15);
    assertEquals("Done!", result);
  }
}
