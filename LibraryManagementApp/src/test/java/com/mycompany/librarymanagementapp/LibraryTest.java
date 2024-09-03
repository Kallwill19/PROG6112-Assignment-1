/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.librarymanagementapp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    // Fields for testing the Library class
    private Library library; // Library object for testing
    private Book fictionBook; // FictionBook object for testing
    private Book nonFictionBook; // NonFictionBook object for testing

    @BeforeEach
    public void setUp() {
        // Initialize library and book objects before each test
        library = new Library();
        fictionBook = new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", "Novel");
        nonFictionBook = new NonFictionBook("Sapiens", "Yuval Noah Harari", "History");
        library.addBook(fictionBook); // Add a fiction book to the library
        library.addBook(nonFictionBook); // Add a non-fiction book to the library
    }

    @Test
    public void testAddBook() {
        // Test adding books to the library
        assertEquals(2, library.getBooks().size()); // Verify that the library contains 2 books
        assertEquals("The Great Gatsby", library.getBooks().get(0).getTitle()); // Verify the title of the first book
        assertEquals("Sapiens", library.getBooks().get(1).getTitle()); // Verify the title of the second book
    }

    @Test
    public void testBorrowBook() {
        // Test borrowing a book
        library.borrowBook("The Great Gatsby"); // Borrow a book
        assertFalse(fictionBook.isAvailable()); // Verify that the book is not available after borrowing
    }

    @Test
    public void testReturnBook() {
        // Test returning a book
        library.borrowBook("The Great Gatsby"); // Borrow a book first
        library.returnBook("The Great Gatsby"); // Return the borrowed book
        assertTrue(fictionBook.isAvailable()); // Verify that the book is available after returning
    }

    @Test
    public void testBorrowBook_NotFound() {
        // Test borrowing a non-existent book
        library.borrowBook("Nonexistent Book"); // Attempt to borrow a book not in the library
        assertTrue(fictionBook.isAvailable()); // Verify that the existing book's availability is unaffected
        assertTrue(nonFictionBook.isAvailable()); // Verify that the other book's availability is unaffected
    }

    @Test
    public void testPrintReport() {
        // Test printing the library report
        library.printReport(); // Call the method to print the report
        // Manual validation or output capture needed for console output tests
    }
}
