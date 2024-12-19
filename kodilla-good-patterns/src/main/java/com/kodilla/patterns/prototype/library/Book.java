package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;
import java.util.Objects;

public final class Book  {
  final private String title;
  final private String author;
  final private LocalDate publicationDate;

  public Book(final String title, final String author, final LocalDate publicationDate) {
    this.title = title;
    this.author = author;
    this.publicationDate = publicationDate;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public LocalDate getPublicationDate() {
    return publicationDate;
  }

  public void setTitle(final String title) {
    this.title = title;
  }

  public void setAuthor(final String author) {
    this.author = author;
  }

  public void setPublicationDate(final LocalDate publicationDate) {
    this.publicationDate = publicationDate;
  }


  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Book book = (Book) o;
    return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publicationDate, book.publicationDate);
  }

  @Override
  public int hashCode() {
    int result = Objects.hashCode(title);
    result = 31 * result + Objects.hashCode(author);
    result = 31 * result + Objects.hashCode(publicationDate);
    return result;
  }

  @Override
  public String toString() {
    return "Book{" +
        "title='" + title + '\'' +
        ", author='" + author + '\'' +
        ", publicationDate=" + publicationDate +
        '}';
  }
}
