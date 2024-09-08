package com.kodilla.testing.forum;

import com.kodilla.testing.user.SimpleUser;
import org.junit.jupiter.api.*;

public class ForumTestSuite {

  @BeforeEach
  public void before() {
    System.out.println("Test case: begin");
  }

  @AfterEach
  public void after() {
    System.out.println("Test case: end");
  }

  @BeforeAll
  public static void beforeAll() {
    System.out.println("Test suit: begin");
  }

  @AfterAll
  public static void afterAll() {
    System.out.println("Test suit: end");
  }

  @DisplayName(
      "When created a user with simple realName, " +
          "the gerRealName should return a real user Name"
   )
  @Test
  void testCaseRealName(){
    // Given
    SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");
    String expectedResult = "John Smith";

    // When
    String result = simpleUser.getRealName();
    System.out.println("Testing: " + result);

    // Then
    Assertions.assertEquals(expectedResult, result);
  }

  @DisplayName(
      "When created SimpleUser with name, " +
          "then getUsername should return correct name"
  )
  @Test
  void testCaseUsername(){
    // Given
    SimpleUser simpleUser = new SimpleUser("theForumUser", "John Smith");

    // When
    String result = simpleUser.getUserName();
    String expectedResult = "theForumUser";

    // Then
    Assertions.assertEquals(expectedResult, result);

  }
}
