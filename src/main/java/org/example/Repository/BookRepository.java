package org.example.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.Model.Book;

public class BookRepository {
    private List<Book> books = new ArrayList<>();

    public BookRepository() {
        books.add(new Book("Aidyn", "Nurlan", "2006", "kz-19821981"));
        books.add(new Book("Алаш", "Мұхтар Әуезов", "1935", "kz-19350001"));
        books.add(new Book("Көксерек", "Ильяс Есенберлин", "1964", "kz-19640002"));
        books.add(new Book("Абай жолы", "Мұхтар Әуезов", "1942", "kz-19420003"));
        books.add(new Book("Қыз Жібек", "Ғабит Мүсірепов", "1940", "kz-19400004"));
        books.add(new Book("Жұмбақ жала", "Мұқағали Мақатаев", "1970", "kz-19700005"));
        books.add(new Book("Сарыарқа", "Смағұл Елубай", "1982", "kz-19820006"));
        books.add(new Book("Қорқыт", "Жүсіпбек Аймауытов", "1922", "kz-19220007"));
        books.add(new Book("Құлагер", "Мұхтар Әуезов", "1957", "kz-19570008"));
        books.add(new Book("Еңлік-Кебек", "Мұхтар Әуезов", "1943", "kz-19430009"));
        books.add(new Book("Менің атым Қожа", "Бердібек Соқпақбаев", "1966", "kz-19660010"));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public List<Book> findBooksByName(String name) {
        return books.stream()
                .filter(book -> book.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public List<Book> findBooksByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equalsIgnoreCase(isbn))
                .collect(Collectors.toList());
    }
}
