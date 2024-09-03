/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp;

/**
 *
 * @author lab_services_student
 */
public class Book {
    // Private fields to store the title, author, and availability status of the book
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor to initialize the Book object with a title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // By default, the book is available
    }

    // Getter method for the title
    public String getTitle() {
        return title;
    }

    // Getter method for the author
    public String getAuthor() {
        return author;
    }

    // Getter method for the availability status
    public boolean isAvailable() {
        return isAvailable;
    }

    // Protected setter method to change the availability status of the book
    protected void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    // Method to borrow the book
    public void borrowBook() {
        if (isAvailable) { // Check if the book is currently available
            isAvailable = false; // Mark the book as not available
            System.out.println("The book '" + title + "' has been borrowed.");
        } else { // If the book is not available
            System.out.println("The book '" + title + "' is currently unavailable.");
        }
    }

    // Method to return the book
    public void returnBook() {
        isAvailable = true; // Mark the book as available
        System.out.println("The book '" + title + "' has been returned.");
    }

    // Method to display information about the book
    public void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Available: " + (isAvailable ? "Yes" : "No"));
    }
}