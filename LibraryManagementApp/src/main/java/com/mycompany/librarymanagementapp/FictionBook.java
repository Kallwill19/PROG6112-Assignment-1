/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp;

/**
 *
 * @author lab_services_student
 */
public class FictionBook extends Book {
    // Private field to store the genre of the fiction book
    private String genre;

    // Constructor to initialize the FictionBook object with title, author, and genre
    public FictionBook(String title, String author, String genre) {
        super(title, author); // Call the constructor of the parent class (Book)
        this.genre = genre;
    }

    // Method to display information about the fiction book (overrides Book displayInfo)
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo method of the parent class
        System.out.println("Genre: " + genre); // Print the genre of the fiction book
    }
}