package com.kodilla.patterns.factory.tasks;

public class TaskFactory {
  public final Task createTask(final TaskName task) {
    return switch (task) {
      case TaskName.DRIVING -> new DrivingTask("Drive a car", "To a supermarket", "A car");
      case TaskName.PAINTING -> new PaintingTask("New painting job", "Green", "Living room");
      case TaskName.SHOPPING -> new ShoppingTask("Everyday shopping", "Egs", 6);
    };
  }
}
