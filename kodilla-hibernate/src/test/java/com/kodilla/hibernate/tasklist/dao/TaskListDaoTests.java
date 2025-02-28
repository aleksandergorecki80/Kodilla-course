package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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

  @Test
  void testTaskListDaoSaveWithTasks() {
    //Given
    Task task = new Task("Test: Learn Hibernate", 14);
    Task task2 = new Task("Test: Write some entities", 3);

    TaskFinancialDetails tfd = new TaskFinancialDetails(new BigDecimal(20), false);
    TaskFinancialDetails tfd2 = new TaskFinancialDetails(new BigDecimal(10), false);

    task.setTaskFinancialDetails(tfd);
    task2.setTaskFinancialDetails(tfd2);

    TaskList taskList = new TaskList("TASK_LIST_NAME", "ToDo tasks");

    taskList.getTasks().add(task);
    taskList.getTasks().add(task2);
    task.setTaskList(taskList);
    task2.setTaskList(taskList);

    //When
    taskListDao.save(taskList);
    int id = taskList.getId();

    //Then
    assertNotEquals(0, id);

    //CleanUp
    taskListDao.deleteById(id);
  }
}
