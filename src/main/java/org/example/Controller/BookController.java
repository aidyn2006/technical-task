package org.example.Controller;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.example.Exception.BookException;
import org.example.Service.impl.BookServiceImpl;

public class BookController {
    private Scanner scanner;
    private BookServiceImpl bookService;
    private Integer choose;
    private boolean exit = true;

    public BookController(BookServiceImpl bookService, Scanner scanner) {
        this.bookService = bookService;
        this.scanner = scanner;
    }

    public void run() throws BookException {
        while(exit) {
            try {
                System.out.println("Выберите цифру:\n\n " +
                        "- - - - - - - - - - - - - - - - -\n" +
                        "1. Добавить книгу\n" +
                        "2. Удалить книгу\n" +
                        "3. Искать по автору\n" +
                        "4. Искать по названию\n" +
                        "5. Искать по isbn\n" +
                        "6. Отображать все книги\n" +
                        "7. Выход\n");
                choose = scanner.nextInt();
                scanner.nextLine();
                switch (choose) {
                    case 1 -> bookService.addBook();
                    case 2 -> bookService.removeBook();
                    case 3 -> {
                        try {
                            bookService.printBooksByAuthor();
                            addSleep();

                        } catch (BookException e) {
                            throw new BookException("Ошибка при поиске книги по автору: ", e);
                        }
                    }
                    case 4 -> {
                        bookService.printBooksByName();
                        addSleep();
                    }
                    case 5 -> {
                        bookService.printBooksByIsbn();
                        addSleep();
                    }
                    case 6 -> {
                        bookService.printAllBooks();
                        addSleep();
                    }
                    case 7 -> exit = false;
                    default -> throw new BookException("Ошибка: введите корректный номер.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введите число.");
                scanner.next();
            }
        }

    }

    private static void addSleep() {
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException var1) {
            Thread.currentThread().interrupt();
            System.out.println("Произошла ошибка во время ожидания.");
        }

    }
}