package com.kodilla.patterns.prototype.library;

import com.kodilla.patterns.prototype.Prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Library extends Prototype<Library> {
  private String name;
  Set<Book> books = new HashSet<>();

  public Library(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Set<Book> getBooks() {
    return books;
  }

  public Library shallowCopy() throws CloneNotSupportedException {
    return super.clone();
  }

  public Library deepCopy() throws CloneNotSupportedException {
    Library clonedLibrary = super.clone();
    clonedLibrary.books = new HashSet<>();
    for (final Book book : books) {
      Book clonedBook = new Book(book.getTitle(), book.getAuthor(), book.getPublicationDate());
      clonedLibrary.books.add(clonedBook);
    }
    return clonedLibrary;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Library library = (Library) o;
    return Objects.equals(name, library.name) && books.equals(library.books);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(name);
    result = 31 * result + books.hashCode();
    return result;
  }
}
