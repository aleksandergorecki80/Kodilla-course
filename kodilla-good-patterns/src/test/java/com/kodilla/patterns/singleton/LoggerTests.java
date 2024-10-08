package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTests {
  private static Logger logger;

  @BeforeAll
  public static void setUpLog() {
    logger = Logger.INSTANCE;
    logger.log("First log message");
  }

  @Test
  public void testGetLastLog() {
    // Given
    // When
    String log = logger.getLastLog();

    // Then
    assertEquals("First log message", log);
  }
}
