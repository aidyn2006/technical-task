package org.example.Service.impl;

import java.util.List;
import java.util.Scanner;
import org.example.Exception.BookException;
import org.example.Model.Book;
import org.example.Repository.BookRepository;
import org.example.Service.BookService;

public class BookServiceImpl implements BookService {
    private BookRepository repository;
    private Scanner scanner;

    public BookServiceImpl(BookRepository repository, Scanner scanner) {
        this.repository = repository;
        this.scanner = scanner;
    }

    public void addBook() {
        System.out.println("Введите название книги: ");
        String name = scanner.nextLine();
        System.out.println("Введите автора книги: ");
        String author = scanner.nextLine();
        System.out.println("Введите год книги: ");
        String year = scanner.nextLine();
        System.out.println("Введите isbn книги: ");
        String isbn = scanner.nextLine();
        Book book = new Book(name, author, year, isbn);
        repository.addBook(book);
        System.out.println("Книга добавлена: " + book);
    }

    public void removeBook() throws BookException {
        System.out.println("Введите isbn книги который хотите удалить: ");
        String isbn = scanner.nextLine();
        if (!repository.removeBook(isbn)) {
            throw new BookException("Книга с ISBN " + isbn + " не найдена.");
        } else {
            System.out.println("Книга удалена.");
        }
    }

    public void printBooksByAuthor() throws BookException {
        System.out.println("Введите автора книги, которую хотите найти: ");
        String author = scanner.nextLine();
        List<Book> books = repository.findBooksByAuthor(author);
        if (books.isEmpty()) {
            throw new BookException("Книги данного автора не найдены.");
        } else {
            books.forEach(book -> System.out.println(book));
        }
    }

    public void printAllBooks() {
        List<Book> books = repository.getAllBooks();
        books.forEach(book -> System.out.println(book));
    }

    public void printBooksByName() throws BookException {
        System.out.println("Введите название книги, которую хотите найти: ");
        String name = scanner.nextLine();
        List<Book> books = repository.findBooksByName(name);
        if (books.isEmpty()) {
            throw new BookException("Книги по названию: " + name + " не найдены.");
        } else {
            books.forEach(book -> System.out.println(book));
        }
    }

    public void printBooksByIsbn() throws BookException {
        System.out.println("Введите ISBN книги, которую хотите найти: ");
        String isbn = scanner.nextLine();
        List<Book> books = repository.findBooksByIsbn(isbn);
        if (books.isEmpty()) {
            throw new BookException("Книги по isbn: " + isbn + " не найдены.");
        } else {
            books.forEach(book -> System.out.println(book));
        }
    }
}
