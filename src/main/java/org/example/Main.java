package org.example;

import java.util.Scanner;
import org.example.Controller.BookController;
import org.example.Repository.BookRepository;
import org.example.Service.impl.BookServiceImpl;

public class Main {
    public static void main(String[] args) {
        BookRepository bookRepository = new BookRepository();
        Scanner scanner = new Scanner(System.in);
        BookServiceImpl bookService = new BookServiceImpl(bookRepository, scanner);
        BookController UI = new BookController(bookService, scanner);

        try {
            UI.run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
