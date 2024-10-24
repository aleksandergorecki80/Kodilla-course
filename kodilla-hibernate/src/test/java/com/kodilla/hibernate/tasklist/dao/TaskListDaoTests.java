package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TaskListDaoTests {

  @Autowired
  private TaskListDao taskListDao;

  @Test
  void testFindByListName() {
    // Given
    String TASK_LIST_NAME = "Nam eu felis porttitor ipsum";
    TaskList taskList = new TaskList(TASK_LIST_NAME, "Mauris bibendum ex nisi, pharetra feugiat nisl porttitor ut. Nam imperdiet id sapien at tempus. ");

    // When
    taskListDao.save(taskList);

    // Then
    String taskListName = taskList.getListName();
    List<TaskList> fechedTaskList = taskListDao.findByListName(taskListName);
    assertEquals(TASK_LIST_NAME, fechedTaskList.getFirst().getListName());

    // CleanUp
    int id = fechedTaskList.getFirst().getId();
    taskListDao.deleteById(id);
  }
}
