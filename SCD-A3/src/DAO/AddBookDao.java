package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Book;

public class AddBookDao {
    private final Connection connection;

    public AddBookDao(Connection connection) {
        this.connection = connection;
    }

    public void insertBook(Book book) {
        String insertQuery = "INSERT INTO books (book_name, genre, price) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, book.getBookName());
            preparedStatement.setString(2, book.getGenre());
            preparedStatement.setDouble(3, book.getPrice());
            preparedStatement.executeUpdate();
            System.out.println("Book inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting book: " + e.getMessage());
        }
    }
}
