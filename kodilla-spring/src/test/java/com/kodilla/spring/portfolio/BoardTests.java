package com.kodilla.spring.portfolio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BoardTests {
  @Autowired
  public Board board;

  @Test
  void testTaskAdd() {
    // Given
    // When
    board.getToDoList().addTask("Todo task");
    board.getInProgressList().addTask("In progress task");
    board.getDoneList().addTask("Done task");

    // Then
    assertEquals("Todo task", board.getToDoList().getTask(0));
    assertEquals("In progress task", board.getInProgressList().getTask(0));
    assertEquals("Done task", board.getDoneList().getTask(0));
  }
}
