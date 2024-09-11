package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
  @BeforeEach
  public void before() {
    System.out.println("Test of OddNumbersExterminator class has started");
  }

  @AfterEach
  public void after() {
    System.out.println("Test of OddNumbersExterminator class has finished");
  }

  @DisplayName(
      "When a list of numbers is empty, " +
          "then the function should return null."
  )
  @Test
  void testOddNumbersExterminatorEmptyList (){
    // Given
    OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
    List<Integer> listOfNumbers = new ArrayList<>();

    // When
    List<Integer> result = oddNumbersExterminator.exterminate(listOfNumbers);

    // Then
    Assertions.assertNull(result);
  }


  @DisplayName(
      "When created a list of numbers, " +
          "then odd numbers should be removed from the list."
  )
  @Test
  void testOddNumbersExterminatorNormalList (){

    // Given
    OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
    List<Integer> listOfNumbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    // When
    List<Integer> result = oddNumbersExterminator.exterminate(listOfNumbers);

    // Then
    List<Integer> expectedEvenNumbers = Arrays.asList(2, 4, 6, 8, 10);
    Assertions.assertEquals(result, expectedEvenNumbers);
  }
}
