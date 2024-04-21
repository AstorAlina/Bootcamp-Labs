package org.example;

public class Book {
    //instance variables

    private int id;
    private String title;
    private String author;
    private String isbn;
    public boolean CheckedOut;
    public String checkedOutTo;

    //constructor
    public Book(int id, String title, String author, String isbn, boolean CheckedOut, String checkedOutTo) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
        this.CheckedOut = CheckedOut;
        this.checkedOutTo = checkedOutTo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public boolean CheckedOut() {
        return CheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        CheckedOut = checkedOut;
    }


    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }


}


