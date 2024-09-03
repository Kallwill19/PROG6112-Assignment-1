/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp;

import java.util.ArrayList;

/**
 *
 * @author lab_services_student
 */
public class Library {
    // Private field to store the list of books in the library
    private ArrayList<Book> books;

    // Constructor to initialize the Library object
    public Library() {
        books = new ArrayList<>(); // Initialize the books list as a new ArrayList
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book); // Add the book to the list
        System.out.println("Book added: " + book.getTitle());
    }

    // Method to borrow a book by its title
    public void borrowBook(String title) {
        for (Book book : books) { // Iterate through the list of books
            if (book.getTitle().equalsIgnoreCase(title)) { // Check if the book title matches
                book.borrowBook(); // Call the borrowBook method of the matched book
                return;
            }
        }
        // If no book is found with the given title
        System.out.println("The book '" + title + "' is not found in the library.");
    }

    // Method to return a book by its title
    public void returnBook(String title) {
        for (Book book : books) { // Iterate through the list of books
            if (book.getTitle().equalsIgnoreCase(title)) { // Check if the book title matches
                book.returnBook(); // Call the returnBook method of the matched book
                return;
            }
        }
        // If no book is found with the given title
        System.out.println("The book '" + title + "' is not found in the library.");
    }

    // Method to print a report of all books in the library
    public void printReport() {
        System.out.println("Library Report:");
        for (Book book : books) { // Iterate through the list of books
            book.displayInfo(); // Display information for each book
            System.out.println("-------------------------");
        }
    }

    // Getter method to access the list of books (used in unit tests)
    public ArrayList<Book> getBooks() {
        return books;
    }
}