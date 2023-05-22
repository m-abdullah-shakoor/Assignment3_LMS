/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Muhammad Abdullah Sh
 */
public class IssuedBook {
    private int bookID;
    private int userID;
    private int period;
    private String issuedDate;

    public IssuedBook(int bookID, int userID, int period, String issuedDate) {
        this.bookID = bookID;
        this.userID = userID;
        this.period = period;
        this.issuedDate = issuedDate;
    }
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }
    
}
