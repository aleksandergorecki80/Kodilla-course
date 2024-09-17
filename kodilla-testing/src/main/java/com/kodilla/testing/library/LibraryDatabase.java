package com.kodilla.testing.library;

import java.util.List;

public interface LibraryDatabase {
  // a list of books having title beginning with titleFragment
  List<Book> listBooksWithCondition(String condition);

  // a list of books borrowed by the library
  List<Book> listBooksInHandsOf(LibraryUser libraryUser);

  // try to lend a book for a library user
  // returns true when success
  // returns false when a book is unavailable to rent
  boolean rentABook(LibraryUser libraryUser, Book book);

  // return all books borrowed by a library user to the library
  // returns number of books returned to the library
  boolean returnBooks(LibraryUser libraryUser);
}
