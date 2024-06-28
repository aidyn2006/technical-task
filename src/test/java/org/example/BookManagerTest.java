package org.example;


import org.example.Exception.BookException;
import org.example.Model.Book;
import org.example.Repository.BookRepository;
import org.example.Service.impl.BookServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BookManagerTest {

    @Mock
    private BookRepository bookRepository;
    @Mock
    private Scanner scanner;
    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void testAddBook(){
        when(scanner.nextLine()).thenReturn("BookNameAidyn","BookAuthorAidyn","2006","kz-2006");
        bookService.addBook();

        verify(bookRepository,times(1)).addBook(argThat(book ->
                book.getName().equals("BookNameAidyn") &&
                        book.getAuthor().equals("BookAuthorAidyn") &&
                        book.getYear().equals("2006") &&
                        book.getIsbn().equals("kz-2006")));
    }

    @Test
    public void testRemoveBook() throws BookException {
        String isbn="kz-2006";
        when(scanner.nextLine()).thenReturn(isbn);

        when(bookRepository.removeBook(isbn)).thenReturn(true);
        bookService.removeBook();

        verify(bookRepository, times(1)).removeBook(isbn);
    }



    @Test
    public void testPrintBooksByAuthor() throws BookException {
        String author = "Мұхтар Әуезов";

        when(scanner.nextLine()).thenReturn(author);

        List<Book> forTestBooks = Arrays.asList(
                new Book("Книга1", "Мұхтар Әуезов", "1935", "isbn-1"),
                new Book("Книга2", "Мұхтар Әуезов", "1942", "isbn-2"),
                new Book("Книга3", "Мұхтар Әуезов", "1957", "isbn-3"),
                new Book("Книга4", "Мұхтар Әуезов", "1964", "isbn-4")
        );
        when(bookRepository.findBooksByAuthor(author)).thenReturn(forTestBooks);

        bookService.printBooksByAuthor();

        verify(bookRepository, times(1)).findBooksByAuthor(author);
        assertEquals(4, forTestBooks.size());
        assertTrue(forTestBooks.stream().allMatch(book -> author.equals(book.getAuthor())));
    }



}