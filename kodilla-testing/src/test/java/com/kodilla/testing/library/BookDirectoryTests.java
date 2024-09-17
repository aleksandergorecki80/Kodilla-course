package com.kodilla.testing.library;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTests {
    @Mock
    private LibraryDatabase libraryDatabaseMock;

    private List<Book> generateListOfNBooks(int booksQuantity) {
      List<Book> resultList = new ArrayList<>();
      for (int i = 0; i < booksQuantity; i++) {
        Book theBook = new Book("Title " + i, "Author " + i, 1970 + i);
        resultList.add(theBook);
      }
      return resultList;
    }


  @Test
  void testListBooksWithConditionReturnList() {
    // Given
    BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
    List<Book> resultListOfBooks = new ArrayList<>();
    Book bookOne = new Book("Days Without End", "Sebastian Barry", 2016);
    Book bookTwo = new Book("Days Nothing to Envy", "Barbara Demick", 2009);
    Book bookThree = new Book("Days Gone Girl", "Gillian Flynn", 2012);
    Book bookFour = new Book("Days On Writing", "Sebastian Barry", 2000);

    resultListOfBooks.add(bookOne);
    resultListOfBooks.add(bookTwo);
    resultListOfBooks.add(bookThree);
    resultListOfBooks.add(bookFour);

    when(libraryDatabaseMock.listBooksWithCondition("Days")).thenReturn(resultListOfBooks);

    // When
    List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Days");

    // Then
    assertEquals(4, theListOfBooks.size());
  }

  @Test
  void testListBooksWithConditionMoreThan20() {
    // Given
    BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
    List<Book> resultListOfZeroBooks = new ArrayList<>();
    List<Book> resultListOfFifteenBooks = generateListOfNBooks(15);
    List<Book> resultListOfFortyBooks = generateListOfNBooks(40);


    when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOfFifteenBooks);
    when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOfZeroBooks);
    when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOfFortyBooks);

    // When
    List<Book> theListOfZeroBooks = bookLibrary.listBooksWithCondition("ZeroBooks");
    List<Book> theListOfFifteenBooks = bookLibrary.listBooksWithCondition("Any title");
    List<Book> theListOfFortyBooks = bookLibrary.listBooksWithCondition("FortyBooks");

    // Then
    assertEquals(0, theListOfZeroBooks.size());
    assertEquals(15, theListOfFifteenBooks.size());
    assertEquals(0, theListOfFortyBooks.size());
  }

  @Test
  void testListBooksWithConditionFragmentShorterThanThree() {
      // Given
      LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
      BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);

      // When
      List<Book> theListOfTenBooks = bookLibrary.listBooksWithCondition("An");

      // Then
    assertEquals(0, theListOfTenBooks.size());
    verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());

  }

}
