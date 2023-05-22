/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Muhammad Abdullah Sh
 */
public class Users {
    private String username;
    private String password;
     public Users() {
        // Default constructor
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        // Initialize other user-related properties as needed
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
