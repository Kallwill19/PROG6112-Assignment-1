/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.librarymanagementapp;

/**
 *
 * @author lab_services_student
 */
public class NonFictionBook extends Book {
    // Private field to store the field or category of the non-fiction book
    private String field;

    // Constructor to initialize the NonFictionBook object with title, author, and field
    public NonFictionBook(String title, String author, String field) {
        super(title, author); // Call the constructor of the parent class (Book)
        this.field = field;
    }

    // Method to display information about the non-fiction book (overrides Book displayInfo)
    @Override
    public void displayInfo() {
        super.displayInfo(); // Call the displayInfo method of the parent class
        System.out.println("Field: " + field); // Print the field of the non-fiction book
    }
}