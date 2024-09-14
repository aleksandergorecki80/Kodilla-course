package com.kodilla.testing.shape;

public class Triangle implements Shape {
  private final String name;
  private final double base;
  private final double height;

  public Triangle(String name, double base, double height) {
    this.name = name;
    this.base = base;
    this.height = height;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Triangle triangle = (Triangle) o;
    return Double.compare(base, triangle.base) == 0 && Double.compare(height, triangle.height) == 0 && name.equals(triangle.name);
  }

  @Override
  public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + Double.hashCode(base);
    result = 31 * result + Double.hashCode(height);
    return result;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Double getArea() {
    return 0.5 * this.base * this.height;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
