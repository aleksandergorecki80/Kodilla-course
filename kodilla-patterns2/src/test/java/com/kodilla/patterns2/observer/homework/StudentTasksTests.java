package com.kodilla.patterns2.observer.homework;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StudentTasksTests {
    @Test
    public void testNotifyMentor() {
        // Given
        Task task1 = new Task("20.1. Wzorzec Fasada", "https://github.com/aleksandergorecki80/Kodilla-course/commit/583edbf628eabf646f57e2455247895906343bc8");
        Task task2 = new Task("20.2. Wzorzec Dekorator", "https://github.com/aleksandergorecki80/Kodilla-course/tree/master/kodilla-patterns2");
        Task task3 = new Task("20.3. Programowanie aspektowe w Spring Boot", "https://github.com/aleksandergorecki80/Kodilla-course/blob/master/kodilla-patterns2/src/main/java/com/kodilla/patterns2/facade/api/OrderFacadeWatcher.java");

        StudentTasks studentTasks = new StudentTasks("Jan Kowalski");
        Mentor januszWisniewski = new Mentor("Janusz Wiśniewski");
        Mentor andrzejNowak = new Mentor("Andrzej Nowak");

        // When
        studentTasks.registerObserver(januszWisniewski);
        studentTasks.addTask(task1);
        studentTasks.addTask(task2);
        studentTasks.registerObserver(andrzejNowak);
        studentTasks.addTask(task3);

        // Then
        assertEquals(3, januszWisniewski.getUpdateCount());
        assertEquals(1, andrzejNowak.getUpdateCount());
    }
}
