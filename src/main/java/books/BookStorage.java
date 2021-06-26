package books;

import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import books.Book;

@Component
public class BookStorage {
    private static int booksNumber;
    ArrayList<Book> booksList;
    {
        booksList = new ArrayList<>();
    }
    public List<Book> index(){
        return booksList;
    }
    public void save(Book book){
        book.setId(++booksNumber);
        booksList.add(book);
    }
    public Book show(int id){
        return booksList.stream().filter(book -> book.getId() == id).findAny().orElse(null);
    }
    public void delete(int id) {
        booksList.removeIf(p -> p.getId() == id);
    }
}