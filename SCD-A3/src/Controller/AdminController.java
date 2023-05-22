package Controller;

import Model.Book;
import DAO.AddBookDao;
import View.Admin;

public class AdminController {
    private Admin adminView;
    private AddBookDao bookDAO;

    public AdminController(Admin adminView) {
        this.adminView = adminView;
        this.bookDAO = new AddBookDao();
    }

    public void addBook(Book book) {
        bookDAO.insertBook(book);
    }

    // Implement other controller methods as needed

    public static void main(String[] args) {
        Admin adminView = new Admin();
        AdminController adminController = new AdminController(adminView);
        adminView.setController(adminController);
    }
}
