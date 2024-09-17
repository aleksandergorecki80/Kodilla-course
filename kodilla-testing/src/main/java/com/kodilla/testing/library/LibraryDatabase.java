package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
  // lists books having title beginning with title fragment
  List<Book> listBooksWithCondition(String titleFragment);

  // lists books borrowed by libraryUser
  List<Book> listBooksInHandsOf(LibraryUser libraryUser);

  // try to rent a book with a libraryUser
  // returns true when success
  // and returns false when book is unavailable to rent
  boolean rentABook(LibraryUser libraryUser);
}
