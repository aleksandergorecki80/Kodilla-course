package com.kodilla.testing.shape;

public class Square implements Shape {
  private final String name;
  private final double sideLength;

  public Square(String name, double sideLength) {
    this.name = name;
    this.sideLength = sideLength;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Square square = (Square) o;
    return Double.compare(sideLength, square.sideLength) == 0 && name.equals(square.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + Double.hashCode(sideLength);
    return result;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Double getArea() {
    return Math.pow(sideLength, 2);
  }

  @Override
  public String toString() {
    return this.name;
  }
}
