package com.kodilla.spring.library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

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

  @Test
  void testContext() {
    // Given
//    ApplicationContext context = new AnnotationConfigApplicationContext(LibraryConfig.class);
    ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring");

    // When & Then
    System.out.println(" ==== Beans list ==== >>>");
    Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    System.out.println(" <<<==== Beans list ====");

  }
}
