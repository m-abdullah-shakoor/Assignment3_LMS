/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import View.AddBook;
import View.Admin;
import View.IssueBook;
import View.LoginForm;
import View.UsersList;
import View.ViewBook;

import Model.Book;
//import Model.Admin;
import Model.IssuedBook;
import Model.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Muhammad Abdullah Sh
 */

public class DBEstablishment {
public AddBook addBook;
public Admin admin;
public IssueBook issue;
public LoginForm login;
public UsersList user;
public ViewBook view;
private Connection connection;

public void DBEstablishment(){
String url = "jdbc:mysql://localhost:3306/library_mng_sys";
String user = "root";
String pass = null;
 try {
            // Establish a connection to the database
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void viewBooks(){
 try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT bid, bname, genre, price FROM books");
            while (resultSet.next()) {
                int bid = resultSet.getInt("bid");
                String bname = resultSet.getString("bname");
                String genre = resultSet.getString("genre");
                float price = resultSet.getFloat("price");

                System.out.println("BOOK ID: " + bid);
                System.out.println("BOOK NAME : " + bname);
                System.out.println("BOOK GENRE : " + genre);
                System.out.println("BOOK PRICE : " + price);
                System.out.println();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }}
public void viewUsers(){
 try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT username, password FROM users");
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
                System.out.println();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
public void viewIssuedBooks(){
    try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT bid, bname, genre, price, issue FROM books WHERE issue != NULL");
            while (resultSet.next()) {
                int bid = resultSet.getInt("bid");
                String bname = resultSet.getString("bname");
                String genre = resultSet.getString("genre");
                float price = resultSet.getFloat("price");
                String issue = resultSet.getString("issue");

                System.out.println("BOOK ID: " + bid);
                System.out.println("BOOK NAME : " + bname);
                System.out.println("BOOK GENRE : " + genre);
                System.out.println("BOOK PRICE : " + price);
                System.out.println("BOOK ISSUE Date: " + issue);
                System.out.println();
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
}
public void issueBook(String issuedDate, int bookId){ 
    try{
            String sql = "UPDATE books SET issued_date = ? WHERE book_id = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, issuedDate);
                statement.setInt(2, bookId);
                
                int rowsAffected = statement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Book issuance updated successfully.");
                } else {
                    System.out.println("No book found with the given book ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }}
public void addUser(String username, String password){
        try {
            Statement statement = connection.createStatement();
            String usernameInput = username;
            String passwordInput = password;
            String sql = "INSERT INTO users (username, password) VALUES ('" + usernameInput + "', '" + passwordInput + "')";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
public void addBook(int bid, String genre, String bname, String issuedate, float price){
try {
            Statement statement = connection.createStatement();
            int  bookidInput = bid;
            String bookName = bname ;
            String bookgenre = genre;
            String dateissue = null;
            float bookprice = price;
            String sql = "INSERT INTO users (bid, bname, genre, price, issue) VALUES ('" + bookidInput + "', '" + bookName + "', '" + bookgenre + "', '" + bookprice + "', '" + dateissue + "')";
            int rowsAffected = statement.executeUpdate(sql);
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully.");
            } else {
                System.out.println("Failed to insert data.");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }}
public void returnBook(int bid){
try{
        String sql = "UPDATE books SET issued_date = NULL WHERE book_id = ?";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bid);
            
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Book issuance updated successfully.");
            } else {
                System.out.println("No book found with the given book ID.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







 public static void main(String [] args){
    DBEstablishment dbe = new DBEstablishment();
    //dbe.DBEstablishment();
    //dbe.addUser("aaa", "bbb");
   //dbe.viewUsers();
    //dbe.writeuser("asaassd", "efeefefsdf");
    //sdb.saveUserToDatabase("BSE0312", "cxvsdf");
    //dbe.closeConnection();
            java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBook().setVisible(true);
            }
        });

    }   
}
