package org.example;
import java.util.Scanner;

public class Screens {
    public static Book[] book;

    // Create an array to store 20 books
    //Wanted to be inside method because you cant make arrays inside a class
    public static void setupBookInventory() {
        book = new Book[20]; // Array of size 20

        // Initialize each element of the array with a book
        book[0] = new Book(1, "The Alchemist", "Paulo Coelho", "9780061120084", false,  "Sarah Anderson");
        book[1] = new Book(2, "The Road", "Cormac McCarthy", "9780061120034", false, "");
        book[2] = new Book(3, "The Girl with the Dragon Tattoo", "Stieg Larsson", "9780743273565",  false, "");
        book[3] = new Book(4, "The Secret History", "Donna Tartt", "9780141439518",  false, "");
        book[4] = new Book(5, "The Name of the Wind", "Patrick Rothfuss", "9780316769488", true, "Kyle Low");
        book[5] = new Book(6, "The Night Circus", "Erin Morgenstern", "9780547928227", false, "");
        book[6] = new Book(7, "The Goldfinch", "Donna Tartt", "9781408855652", false, "");
        book[7] = new Book(8, "House of Leaves", "Mark Z. Danielewski.", "9780544003415", false, "");
        book[8] = new Book(9, "The Kite Runner", "Khaled Hosseini", "9780061120084", false, "");
        book[9] = new Book(10, "The Book Thief", "Markus Zusak", "9780451524935", false, "");
        book[10] = new Book(11, "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", false, "");
        book[11] = new Book(12, "Pride and Prejudice", "Jane Austen", "9780141439518", true, "Harper Smith");
        book[12] = new Book(13, "The Catcher in the Rye", "J.D. Salinger", "9780316769488", true, "Sarah Jones");
        book[13] = new Book(14, "The Hobbit", "J.R.R. Tolkien", "9780547928227", true, "Mark Zuck");
        book[14] = new Book(15, "Harry Potter and the Philosopher's Stone", "J.K. Rowling", "9781408855652", true, "Terry Long");
        book[15] = new Book(16, "The Lord of the Rings", "J.R.R. Tolkien", "9780544003415", true, "Dennis Nelson");
        book[16] = new Book(17 ,"To Kill a Mockingbird", "Harper Lee", "9780061120084", false, "");
        book[17] = new Book(18, "1984", "George Orwell", "9780451524935", false, "");
        book[18] = new Book(19, "The Master and Margarita", "Mikhail Bulgakov", "9780743273565",  false, "");
        book[19] = new Book(20,"If on a winter's night a traveler", " Italo Calvino", "9780141439518",  true, "Jenny Hard");
    }


    public static void showAvailableBooks() {

        System.out.println("Here is a list of available books: ");
        for (Book book : book) {
            if (book.isCheckedOut() == false) {
                System.out.printf("ID: %d, Title: %s, ISBN: %s, Is checked out: %b \n",
                        book.getId(), book.getTitle(), book.getIsbn(), book.isCheckedOut);

            }


        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select an option: ");
        System.out.println("(1) Check out a book");
        System.out.println("(2) Go back to home screen");
        var input = scanner.nextLine();
        if (input.equals("1")) {
            checkOutBook();

        } else if (input.equals("2")) {
            Main.homeScreen();
        }

    }


    //display of checked out books
    public static void checkedOutBooks() {
        System.out.println("Here is a list of Books that are currently checked out: ");
        for (Book book : book) {
            if (book.isCheckedOut() == true) {
                System.out.printf("ID: %d, Title: %s, ISBN: %s, Checked Out?: %b, Who Checked Out: %s\n",
                        book.getId(), book.getTitle(), book.getIsbn(), book.isCheckedOut(), book.checkedOutTo);
            }

        }
        System.out.println("Please select an option: ");
        System.out.println("(1) Check in a book");
        System.out.println("(2) Go back to home screen");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        if (input.equals("1")) {
            checkInBook(); // Call the method to check in the book

            // Only go back to the home screen if the book check-in process is completed
            Main.homeScreen();
        } else if (input.equals("2")) {
            Main.homeScreen(); // Go back to the home screen
        } else {
            System.out.println("Invalid option");
        }

    }

    //display of books
    public static void checkInBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please provide the ID of the book you want to check in:");
        int input = scanner.nextInt();

        for (Book book : book) {
            if (input == book.getId()) {
                book.setCheckedOut(false);
                System.out.println("Book: " + book.getTitle() + " is checked in!");
            }

        }

    }

    public static void checkOutBook() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please provide the ID of the book you want to check out:");
        int input = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your name:");
        String name = scanner.nextLine();

        for (Book book : book) {
                if (input == book.getId()) {
                book.setCheckedOutTo(name);
                book.setCheckedOut(true);
                System.out.println("The book " + book.getTitle()  + " is checked out!");


                Main.homeScreen();
            }

        }


    }
}


//screens will call checkin and checkout method