package Controller;

import DAO.AddBookDao;
import Model.Book;

public class AddBookController {
    public AddBookDao bookDAO;

    public AddBookController(AddBookDao bookDAO) {
        this.bookDAO = bookDAO;
    }

    public void addBook(Book book) {
        // Perform any necessary validation or business logic here

        // Call the DAO to insert the book into the database
        bookDAO.insertBook(book);
    }
}
