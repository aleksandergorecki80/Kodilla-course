package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class LibraryTests {

  @Autowired
  public Library library;

  @Test
  void testLoadFromDb() {
    // Given
    // When
    library.loadFromDB();

    // Then
    // do nothing
  }

  @Test
  void testSaveToDb() {
    // Given
    // When
    library.saveToDB();

    // Then
    // do nothing
  }
}
