package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskFactoryTests {
  @Nested
  @DisplayName("Tests for Painting")
  class Painting {
    @Test
    void testFactoryPaintingTaskNotExecuted() {
      // Given
      TaskFactory factory = new TaskFactory();

      // When
      Task painting = factory.createTask(TaskName.PAINTING);

      // Then
      assertEquals("New painting job", painting.getTaskName());
      assertEquals(false, painting.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTaskExecuted() {
      // Given
      TaskFactory factory = new TaskFactory();

      // When
      Task painting = factory.createTask(TaskName.PAINTING);
      painting.executeTask();

      // Then
      assertEquals("New painting job", painting.getTaskName());
      assertEquals(true, painting.isTaskExecuted());
    }
  }

  @Nested
  @DisplayName("Tests for Shopping")
  class Shopping {
    @Test
    void testFactoryShoppingTaskNotExecuted() {
      // Given
      TaskFactory factory = new TaskFactory();

      // When
      Task shopping = factory.createTask(TaskName.SHOPPING);

      // Then
      assertEquals("Everyday shopping", shopping.getTaskName());
      assertEquals(false, shopping.isTaskExecuted());
    }

    @Test
    void testFactoryShoppingTaskExecuted() {
      // Given
      TaskFactory factory = new TaskFactory();

      // When
      Task shopping = factory.createTask(TaskName.SHOPPING);
      shopping.executeTask();

      // Then
      assertEquals("Everyday shopping", shopping.getTaskName());
      assertEquals(true, shopping.isTaskExecuted());
    }
  }

  @Nested
  @DisplayName("Tests for Driving")
  class Driving {
    @Test
    void testFactoryDrivingTaskNotExecuted() {
      // Given
      TaskFactory factory = new TaskFactory();

      // When
      Task driving = factory.createTask(TaskName.DRIVING);

      // Then
      assertEquals("Drive a car", driving.getTaskName());
      assertEquals(false, driving.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTaskExecuted() {
      // Given
      TaskFactory factory = new TaskFactory();

      // When
      Task driving = factory.createTask(TaskName.DRIVING);
      driving.executeTask();

      // Then
      assertEquals("Drive a car", driving.getTaskName());
      assertEquals(true, driving.isTaskExecuted());
    }
  }
}
