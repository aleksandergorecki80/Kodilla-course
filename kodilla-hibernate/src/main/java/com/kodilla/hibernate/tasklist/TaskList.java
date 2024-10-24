package com.kodilla.hibernate.tasklist;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="TASKLIST")
public class TaskList {
  private int id;
  private String listName;
  private String description;

  public TaskList() {
  }

  public TaskList(String listName, String description) {
    this.listName = listName;
    this.description = description;
  }

  @Id
  @NotNull
  @GeneratedValue
  @Column(name="ID", unique = true)
  public int getId() {
    return id;
  }

  @Column(name="LISTNAME")
  public String getListName() {
    return listName;
  }

  @Column(name="DESCRIPTION")
  public String getDescription() {
    return description;
  }

  private void setId(final int id) {
    this.id = id;
  }

  private void setListName(final String listName) {
    this.listName = listName;
  }

  private void setDescription(final String description) {
    this.description = description;
  }
}
