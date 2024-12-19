package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

  @Nested
  @DisplayName("Test the listBooksWithCondition method")
  class ListBooksWithCondition {

    @Test
    void testListBooksWithConditionReturnList() {
      // Given
      BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
      List<Book> resultListOfBooks = new ArrayList<>();
      Book bookOne = new Book("Days without end", "Sebastian Blackberry", 2016);
      Book bookTwo = new Book("Days of nothing to envy", "Gillian Blueberry", 2009);
      Book bookThree = new Book("Day when the girl has gone ", "Barbara Flynn", 2012);
      Book bookFour = new Book("Days of waiting", "Stephan Prince", 2000);

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


  @Nested
  @DisplayName("Test the listBooksWithCondition method")
  class ListBooksInHandsOf {
    private LibraryUser libraryUser;

    @BeforeEach
    public void before() {
      libraryUser = new LibraryUser("John", "Doe", "8703124455");
    }

    @Test
      void testListBooksInHandsOfZeroBooks() {
      // Given
      BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
      List<Book> resultListOfZeroBooks = new ArrayList<>();
      when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfZeroBooks);

      // When
      List<Book> theListOfZeroBooks = bookLibrary.listBooksInHandsOf(libraryUser);

      // Then
      assertEquals(0, theListOfZeroBooks.size());
    }

    @Test
    void testListBooksInHandsOfOneBook() {
      // Given
      BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
      List<Book> resultListOfOneBook = new ArrayList<>();
      Book bookOne = new Book("Days Without End", "Sebastian Barry", 2016);
      resultListOfOneBook.add(bookOne);

      when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfOneBook);

      // When
      List<Book> theListOfOneBook = bookLibrary.listBooksInHandsOf(libraryUser);

      // Then
      assertEquals(1, theListOfOneBook.size());
    }

    @Test
    void testListBooksInHandsOfFiveBooks() {
      // Given
      BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
      List<Book> resultListOfFiveBooks = generateListOfNBooks(5);
      when(libraryDatabaseMock.listBooksInHandsOf(libraryUser)).thenReturn(resultListOfFiveBooks);

      // When
      List<Book> theListOfOneBook = bookLibrary.listBooksInHandsOf(libraryUser);

      // Then
      assertEquals(5, theListOfOneBook.size());
    }
  }

}
