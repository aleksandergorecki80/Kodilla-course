package com.kodilla;

import com.kodilla.good.patterns.challenges.MovieStore;

public class Main {
  public static void main(String[] args) {

    System.out.println("Hello world!");
    MovieStore movieStore = new MovieStore();
    String titles = movieStore.getTitles();
    System.out.println(titles);
  }
}
