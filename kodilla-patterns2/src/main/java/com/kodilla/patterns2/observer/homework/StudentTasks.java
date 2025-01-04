package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class StudentTasks implements Observable {
    private final String studentName;
    private final List<Task> studentTasks;
    private final List<Observer> mentors;

    public StudentTasks(String studentName) {
        mentors = new ArrayList<>();
        studentTasks = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addTask(Task task) {
        studentTasks.add(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer mentor) {
        mentors.add(mentor);
    }

    @Override
    public void notifyObservers() {
        for (Observer mentor : mentors) {
            mentor.update(this);
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public List<Task> getStudentTasks() {
        return studentTasks;
    }
}
