package Model;

// Book class representing the book details
public class Book {
    private String bookName;
    private String genre;
    private double price;

    // Constructor
    public Book(String bookName, String genre, double price) {
        this.bookName = bookName;
        this.genre = genre;
        this.price = price;
    }

    // Getters and setters
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}