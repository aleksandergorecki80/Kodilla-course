package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTests {

    @Test
    public void testPublicationYearMedian() {

        // Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("J.K. Rowling", "Harry Potter and the Philosopher's Stone", 1997, "HP001"));
        bookSet.add(new Book("J.R.R. Tolkien", "The Hobbit", 1937, "TH001"));
        bookSet.add(new Book("George Orwell", "1984", 1949, "GEO1984"));
        bookSet.add(new Book("Mary Shelley", "Frankenstein", 1818, "MS001"));
        bookSet.add(new Book("F. Scott Fitzgerald", "The Great Gatsby", 1925, "FSF001"));

        // When
        MedianAdapter medianAdapter = new MedianAdapter();
        int publicationYearMedian = medianAdapter.publicationYearMedian(bookSet);

        // Then
        System.out.println(publicationYearMedian);
        assertEquals(1937, publicationYearMedian);
    }
}
