package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamMain {
  public static void main(String[] args) {
//    People.getList().stream()
//        .map(String::toUpperCase)
//        .filter(s -> s.length() > 11)
//        .map(s -> s.substring(0, s.indexOf(' ') + 2) + ".")
//        .filter(s -> s.charAt(0) == 'M')
//        .forEach(System.out::println);

    // PRINTING THE LIST
//    BookDirectory bookDirectory = new BookDirectory();
//    bookDirectory.getList().stream()
//        .filter(book -> book.getYearOfPublication() > 2010)
//        .forEach(System.out::println);

//    TERMINATE LIST TO LIST
//    BookDirectory bookDirectory = new BookDirectory();
//    List<Book> theResultListOffBooks = bookDirectory.getList().stream()
//        .filter(book -> book.getYearOfPublication() > 2010)
//        .collect(Collectors.toList());
//
//    System.out.println("# elements: " + theResultListOffBooks.size());
//    theResultListOffBooks.stream()
//        .forEach(System.out::println);

    // TERMINATE LIST TO MAP
//    BookDirectory bookDirectory = new BookDirectory();
//
//    Map<String, Book> theResultMapOfBook = bookDirectory.getList().stream()
//        .filter(book -> book.getYearOfPublication() > 2005)
//        .collect(Collectors.toMap(Book::getSignature, book -> book));
//
//    System.out.println("# elements: " + theResultMapOfBook.size());
//    theResultMapOfBook.entrySet().stream()
//        .map(entry -> entry.getKey() + ": " + entry.getValue())
//        .forEach(System.out::println);

    // TERMINATE JOINING
    BookDirectory bookDirectory = new BookDirectory();
    String theResultStringOfBooks = bookDirectory.getList().stream()
        .filter(book -> book.getYearOfPublication() > 2005)
        .map(Book::toString)
        .collect(Collectors.joining(",\n", "<<", ">>"));

    System.out.println(theResultStringOfBooks);

  }
}

