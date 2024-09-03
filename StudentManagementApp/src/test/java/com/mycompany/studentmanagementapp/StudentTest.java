/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.studentmanagementapp;

import java.util.ArrayList;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author lab_services_student
 */
public class StudentTest {
    
 // Instance variables to be used in the test methods
    private ArrayList<Student> studentList;
    private Student student;
    
    
// Setup method to initialize common test data before each test method is run
    @BeforeEach
    public void setUp() {
        studentList = new ArrayList<>(); // Initialize the student list as a new ArrayList
        student = new Student("S001", "John Doe", 20, "Software Development"); // Create a new Student object
        studentList.add(student); // Add the created Student to the student list
    }
    
// Test method to verify the saveStudent functionality
    @Test
    public void testSaveStudent() {
        //Initialize test data
        String id = "S002";
        String name = "Jane Doe";
        int age = 22;
        String course = "Information Management";
        Student newStudent = new Student(id, name, age, course);

        // Add the new student to the student list
        studentList.add(newStudent);

        // Assert: Verify the action had the expected results
        assertEquals(2, studentList.size());
        assertEquals("Jane Doe", studentList.get(1).getName());
        assertEquals(22, studentList.get(1).getAge());
        assertEquals("Information Management", studentList.get(1).getCourse());
    }
    
// Test method to verify the searchStudent functionality
    @Test
    public void testSearchStudent() {
        
        String id = "S001";
        Scanner scanner = new Scanner(id);
        Student.searchStudent(studentList, scanner);

        // Assert
        assertEquals("John Doe", studentList.get(0).getName());
        assertEquals(20, studentList.get(0).getAge());
        assertEquals("Software Development", studentList.get(0).getCourse());
    }
    
// Test method to verify the searchStudent functionality when the student is not found
    @Test
    public void testSearchStudent_StudentNotFound() {
        
        String id = "S002";
        Scanner scanner = new Scanner(id);
        Student.searchStudent(studentList, scanner);

        // Assert
        assertEquals(1, studentList.size());
    }

// Test method to verify the deleteStudent functionality    
    @Test
    public void testDeleteStudent() {
        
        String idToDelete = "S001";
        Scanner scanner = new Scanner(idToDelete);
        
        
        Student.deleteStudent(studentList, scanner);

        // Assert
        assertEquals(0, studentList.size());
    }

 // Test method to verify the deleteStudent functionality when the student is not found    
    @Test
    public void testDeleteStudent_StudentNotFound() {
        
        String idToDelete = "S002";
        Scanner scanner = new Scanner(idToDelete);
        
        
        Student.deleteStudent(studentList, scanner);

        // Assert
        assertEquals(1, studentList.size());
    }
// Test method to verify the editStudentDetails functionality
    @Test
    public void testEditStudentDetails() {
        
        Scanner scanner = new Scanner("S001\nJane Smith\n25\nMobile Application Development\n");
        
        
        Student.editStudentDetails(studentList, scanner);
        
        // Assert
        assertEquals("Jane Smith", studentList.get(0).getName());
        assertEquals(25, studentList.get(0).getAge());
        assertEquals("Mobile Application Development", studentList.get(0).getCourse());
    }
    
 // Test method to verify the studentReport functionality
    @Test
    public void testStudentReport() {
        // Capture output for validation
        String id = "S001";
        Student student = new Student(id, "John Doe", 20, "Software Development");
        studentList.add(student);
        Student.studentReport(studentList);
        
        // Assert - Check manually if the correct report is printed
        assertEquals(2, studentList.size());
    }
    
    @Test
    public void testStudentAge_StudentAgeValid() {
        
        String ageInput = "20";
        Scanner scan = new Scanner(ageInput);

        
        int age = Integer.parseInt(scan.nextLine());

        // Assert
        assertTrue(age >= 16);
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        
        String ageInput = "15";
        Scanner sc = new Scanner(ageInput);

        
        int age = Integer.parseInt(sc.nextLine());

        // Assert
        assertTrue(age < 16);
    }
    
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        
        String ageInput = "abc";
        Scanner scanner = new Scanner(ageInput);

        // Act and Assert: Perform the action and check that it throws the expected exception
        assertThrows(NumberFormatException.class, () -> {  // Check if the following code block throws a NumberFormatException
            Integer.parseInt(scanner.nextLine());  // Attempt to convert the non-numeric input from the scanner to an integer
    });
      
    }

}