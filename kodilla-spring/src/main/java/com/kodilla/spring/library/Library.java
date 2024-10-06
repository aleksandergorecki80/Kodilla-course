package com.kodilla.spring.library;


import java.util.ArrayList;
import java.util.List;

public class Library {
  private final List<String> books = new ArrayList<>();

//  @Autowired
  private LibraryDbController libraryDbController;

//  @Autowired
  public Library(final LibraryDbController libraryDbController) {
    this.libraryDbController = libraryDbController;
  }

  public Library () {
    // do nothing
  }

//  @Autowired
//  public void setLibraryDbController(LibraryDbController libraryDbController) {
//    this.libraryDbController = libraryDbController;
//  }

  public void saveToDB() {
    libraryDbController.saveData();
  }

  public void loadFromDB() {
    libraryDbController.loadData();
  }
}
