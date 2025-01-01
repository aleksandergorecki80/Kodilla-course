package com.kodilla.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//public class Library {
//  private final List<String> books = new ArrayList<>();
//
////  @Autowired
//  private LibraryDbController libraryDbController;
//
////  @Autowired
//  public Library(final LibraryDbController libraryDbController) {
//    this.libraryDbController = libraryDbController;
//  }
//
//  public Library () {
//    // do nothing
//  }
@Service
public class Library {
  private final List<String> books = new ArrayList<>();

  @Autowired
  private LibraryDbController libraryDbController;

//  @Autowired
//  public Library(final LibraryDbController libraryDbController) {
//    this.libraryDbController = libraryDbController;
//  }
//
//  public Library () {
//    // do nothing
//  }

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
