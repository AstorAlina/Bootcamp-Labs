package org.example;

public class Book {
    //instance variables

    private int id;
    private String title;
    private String author;
    private String isbn;
    public boolean isCheckedOut;
    public String checkedOutTo;

    //constructor
    public Book(int id, String title, String author, String isbn, boolean isCheckedOut, String checkedOutTo) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.id = id;
        this.isCheckedOut = isCheckedOut;
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

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }


    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }


    //    //-------------------------------------------------------------//
//    public void checkOut(String name) {
////        checkedOutTo = name;
////        isCheckedOut = true;
//
//    }

//    public void checkIn (){
//        checkedOutTo = "";
//        isCheckedOut = false;
//
//    }

}


