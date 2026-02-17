package Chapter7.Exercise2;

/**
 * Exercise 7.2 — Create a Book class with fields: title, author, pages, isRead (boolean).
 * Create a constructor, a markAsRead() method, and a toString() method that returns a formatted string.
 * Create 3 Book objects in main and display them.
 * */
public class Book {
    private final String title;
    private final String author;
    private final int pages;
    private boolean isRead;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isRead = false;
    }

    public void markAsRead() {
        this.isRead = true;
    }

    @Override
    public String toString() {
        String status = (isRead ? "Read" : "Not read yet");
        return "Title: " + title + " || Author: " + author
                +  " || Pages: " + pages
                + " || Reading status: " + status;
    }


}
