package org.example.Service;

import org.example.Exception.BookException;

public interface BookService {
    void addBook();

    void removeBook() throws BookException;

    void printBooksByAuthor() throws BookException;

    void printAllBooks();

    void printBooksByName() throws BookException;

    void printBooksByIsbn() throws BookException;
}
