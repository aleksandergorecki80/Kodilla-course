package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTests {
  @Test
  void testGetBooks() {

    // Given
    Library myLibrary = new Library("My private library");
    IntStream.iterate(1, i -> i + 1)
        .limit(10)
        .forEach(n -> myLibrary.getBooks().add(new Book(
            "Title " + n,
            "Author " + n,
            LocalDate.of(2020, 1, 1).plusDays(n))));

    // making a shallow copy of library
    Library myLibraryShallowCopy = null;
    try {
      myLibraryShallowCopy = myLibrary.shallowCopy();
      myLibraryShallowCopy.setName("Library shallow copy");
    } catch (CloneNotSupportedException e) {
      System.out.println(e);
    }

    // making a deep copy of library
    Library myLibraryDeepCopy = null;
    try {
      myLibraryDeepCopy = myLibrary.deepCopy();
      myLibraryDeepCopy.setName("Library deep copy");
    } catch (CloneNotSupportedException e) {
      System.out.println(e);
    }

    // When
    Book anExtraBook = new Book("Extra title", "Extra author", LocalDate.of(2020, 1, 1));
    myLibraryShallowCopy.getBooks().add(anExtraBook);

    // Then
    System.out.println(myLibrary);
    System.out.println(myLibraryShallowCopy);
    System.out.println(myLibraryDeepCopy);

    assertEquals(11, myLibrary.getBooks().size());
    assertEquals(11, myLibraryShallowCopy.getBooks().size());
    assertEquals(10, myLibraryDeepCopy.getBooks().size());

    assertEquals(myLibrary.getBooks(), myLibraryShallowCopy.getBooks());
    assertNotEquals(myLibrary.getBooks(), myLibraryDeepCopy.getBooks());

    myLibrary.getBooks().remove(anExtraBook);

    assertEquals(10, myLibrary.getBooks().size());
    assertEquals(10, myLibraryShallowCopy.getBooks().size());

    assertEquals(myLibrary.getBooks(), myLibraryDeepCopy.getBooks());
  }
}
