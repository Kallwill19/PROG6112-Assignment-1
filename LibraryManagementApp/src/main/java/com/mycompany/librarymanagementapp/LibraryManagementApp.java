/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementapp;

import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */

/*
application called Library Management app. This app will help manage a small library by allowing users to:
-Add new books.
-Borrow books.
-Return books.
-View a report of all books, including their availability status.
*/
public class LibraryManagementApp {
    public static void main(String[] args) {
        Library library = new Library(); // Create a new Library object
        Scanner sc = new Scanner(System.in); // Initialize Scanner for user input
        String choice; // Variable to store user menu choice

        while (true) { // Infinite loop to keep the application running until the user chooses to exit
            // Display the main menu to the user
            System.out.println("\nLIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. Add a new book");
            System.out.println("2. Borrow a book");
            System.out.println("3. Return a book");
            System.out.println("4. View library report");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextLine(); // Read user input for menu choice

            switch (choice) {
                case "1":
                    // Case for adding a new book
                    System.out.print("Enter book type (Fiction/NonFiction): ");
                    String type = sc.nextLine(); // Read user input for book type
                    System.out.print("Enter title: ");
                    String title = sc.nextLine(); // Read user input for book title
                    System.out.print("Enter author: ");
                    String author = sc.nextLine(); // Read user input for book author

                    if (type.equalsIgnoreCase("Fiction")) {
                        // If the user chooses to add a fiction book
                        System.out.print("Enter genre: ");
                        String genre = sc.nextLine(); // Read user input for genre
                        library.addBook(new FictionBook(title, author, genre)); // Add the fiction book to the library
                    } else if (type.equalsIgnoreCase("NonFiction")) {
                        // If the user chooses to add a non-fiction book
                        System.out.print("Enter field: ");
                        String field = sc.nextLine(); // Read user input for field
                        library.addBook(new NonFictionBook(title, author, field)); // Add the non-fiction book to the library
                    } else {
                        System.out.println("Invalid book type."); // Handle invalid book type input
                    }
                    break;

                case "2":
                    // Case for borrowing a book
                    System.out.print("Enter title of the book to borrow: ");
                    String borrowTitle = sc.nextLine(); // Read user input for book title to borrow
                    library.borrowBook(borrowTitle); // Borrow the book from the library
                    break;

                case "3":
                    // Case for returning a book
                    System.out.print("Enter title of the book to return: ");
                    String returnTitle = sc.nextLine(); // Read user input for book title to return
                    library.returnBook(returnTitle); // Return the book to the library
                    break;

                case "4":
                    // Case for viewing the library report
                    library.printReport(); // Print the report of all books in the library
                    break;

                case "5":
                    // Case for exiting the application
                    System.out.println("Exiting the application. Goodbye!");
                    System.exit(0); // Terminate the application
                    break;

                default:
                    // Handle invalid menu choice
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        }
    }
}