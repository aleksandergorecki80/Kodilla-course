package com.kodilla.patterns.factory.tasks;

public class DrivingTask extends BaseTask {
  private final String where;
  private final String using;

  public DrivingTask(final String taskName, final String where, final String using) {
    super(taskName);
    this.where = where;
    this.using = using;
  }
}
