package com.kodilla.testing.shape;
import org.junit.jupiter.api.*;

@DisplayName("TDD: Shape Collector Test Suite")
public class ShapesTests {

  @Nested
  @DisplayName("Test the square")
  class TestSquare {
    @Test
    void testGetArea() {
      // Given
      Shape square = new Square("Square one", 4);
      // When
      double squareArea = square.getArea();
      // Then
      Assertions.assertEquals(16, squareArea);
    }

    @Test
    void testGetName() {
      // Given
      Shape square = new Square("Square one", 4);
      // When
      String name = square.getName();
      // Then
      Assertions.assertEquals("Square one", name);
    }
  }

  @Nested
  @DisplayName("Test the circle")
  class TestCircle {
    @Test
    void testGetArea() {
      // Given
      Shape circle = new Circle("Circle one", 4);
      // When
      double circleArea = circle.getArea();
      // Then
      Assertions.assertEquals(50.27, circleArea);
    }

    @Test
    void testGetName() {
      // Given
      Shape circle = new Circle("Circle one", 4);
      // When
      String name = circle.getName();
      // Then
      Assertions.assertEquals("Circle one", name);
    }
  }

  @Nested
  @DisplayName("Test the triangle")
  class TestTriangle {
    @Test
    void testGetArea() {
      // Given
      Shape triangle = new Triangle("Triangle one", 4, 15);
      // When
      double triangleArea = triangle.getArea();
      // Then
      Assertions.assertEquals(30, triangleArea);
    }

    @Test
    void testGetName() {
      // Given
      Shape triangle = new Triangle("Triangle one", 4, 15);
      // When
      String name = triangle.getName();
      // Then
      Assertions.assertEquals("Triangle one", name);
    }
  }

  @Nested
  @DisplayName("Testing ShapeCollector")
  class ShapeCollectorTests {
    @Test
    void testShowFigures(){
    // Given
    Shape square = new Square("Square", 4);
    Shape circle = new Circle("Circle", 4);
    Shape triangle = new Triangle("Triangle", 4, 12);
    ShapeCollector shapeCollector = new ShapeCollector();
    shapeCollector.addFigure(square);
    shapeCollector.addFigure(circle);
    shapeCollector.addFigure(triangle);
    // When
    String result = shapeCollector.showFigures();
    // Then
    Assertions.assertEquals("SquareCircleTriangle", result);
    }

    @Test
    void testAddFigure() {
      // Given
      ShapeCollector shapeCollector = new ShapeCollector();
      Shape square = new Square("Square one", 4);
      // When
      shapeCollector.addFigure(square);
      // Then
      Assertions.assertEquals(shapeCollector.getShapesCollectionSize(), 1);
    }

    @Test
    void testRemoveFigure(){
      // Given
      Shape square = new Square("Square", 4);
      Shape circle = new Circle("Circle", 4);
      Shape triangle = new Triangle("Triangle", 4, 12);
      ShapeCollector shapeCollector = new ShapeCollector();
      shapeCollector.addFigure(square);
      shapeCollector.addFigure(circle);
      shapeCollector.addFigure(triangle);
      // When
      shapeCollector.removeFigure(square);
      // Then
      Assertions.assertEquals(2, shapeCollector.getShapesCollectionSize());
    }

    @Test
    void testGetFigure(){
      // Given
      Shape square = new Square("Square", 4);
      Shape circle = new Circle("Circle", 4);
      Shape triangle = new Triangle("Triangle", 4, 12);
      ShapeCollector shapeCollector = new ShapeCollector();
      shapeCollector.addFigure(square);
      shapeCollector.addFigure(circle);
      shapeCollector.addFigure(triangle);
      // When
      Shape shape = shapeCollector.getFigure(1);
      // Then
      Assertions.assertEquals(circle, shape);
    }
  }
}
