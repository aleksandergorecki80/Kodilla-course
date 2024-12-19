package com.kodilla.testing.shape;

public class Circle implements Shape {
  private final String name;
  private final double radius;

  public Circle(String name, double radius) {
    this.name = name;
    this.radius = radius;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Circle circle = (Circle) o;
    return Double.compare(radius, circle.radius) == 0 && name.equals(circle.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + Double.hashCode(radius);
    return result;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Double getArea() {
    double area = Math.PI * Math.pow(this.radius, 2);
    return Math.round(area * 100.0) / 100.0;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
