package com.kodilla.hibernate.task;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name="TASKS")
public class Task {
  private int id;
  private String description;
  private int duration;
  private Date created;

  public Task() {
  }

  public Task(String description, int duration) {
    this.description = description;
    this.duration = duration;
    this.created = new Date();
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name="ID", unique=true)
  public int getId() {
    return id;
  }

  @Column(name = "DESCRIPTION")
  public String getDescription() {
    return description;
  }

  @NotNull
  @Column(name = "CREATED")
  public Date getCreated() {
    return created;
  }

  @Column(name = "DURATION")
  public int getDuration() {
    return duration;
  }

  private void setId(final int id) {
    this.id = id;
  }

  private void setDescription(final String description) {
    this.description = description;
  }

  private void setDuration(final int duration) {
    this.duration = duration;
  }

  private void setCreated(final Date created) {
    this.created = created;
  }
}