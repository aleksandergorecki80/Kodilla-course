package com.kodilla.patterns.factory.tasks;

public class PaintingTask extends BaseTask {
  private final String color;
  private final String whatToPaint;

  public PaintingTask(final String taskName, final String color, final String whatToPaint) {
    super(taskName);
    this.color = color;
    this.whatToPaint = whatToPaint;
  }
}
