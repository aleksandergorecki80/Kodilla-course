package com.kodilla.patterns.factory.tasks;

public class BaseTask implements Task {
  protected final String taskName;
  protected boolean isExecuted;

  public BaseTask(final String taskName) {
    this.taskName = taskName;
  }

  @Override
  public void executeTask() {
    this.isExecuted = true;
  }

  @Override
  public String getTaskName() {
    return taskName;
  }

  @Override
  public boolean isTaskExecuted() {
    return isExecuted;
  }
}
