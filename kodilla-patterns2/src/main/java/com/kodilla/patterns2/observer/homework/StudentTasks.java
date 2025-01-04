package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

public class StudentTasks implements Observable {
    private String studentName;
    private List<Task> studentTasks;
    private final List<Observer> mentors;

    public StudentTasks(List<Observer> observers, List<Task> studentTasks, String studentName) {
        this.mentors = new ArrayList<>();
        this.studentTasks = new ArrayList<>();
        this.studentName = studentName;
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
}
