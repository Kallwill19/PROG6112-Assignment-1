/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
// Student class to manage student information and methods
class Student {
    private String id;
    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(String id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    
    public String getCourse() {
        return course;
    }
    
    // Setter methods to allow editing of student details
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
     public void setCourse(String course) {
        this.course = course;
    }

    // Method to save a student
    public static void saveStudent(ArrayList<Student> studentList, Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        int age;
        while (true) {
            try {
                System.out.print("Enter Student Age (must be 16 or older): ");
                age = Integer.parseInt(sc.nextLine());
                if (age >= 16) break; // Valid age
                else System.out.println("Age must be 16 or older. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number for age.");
            }
        }
        
         System.out.print("Enter Student Course: ");
            String course = sc.nextLine(); // Prompt for course input

        // Add student to the list
        studentList.add(new Student(id, name, age, course));
        System.out.println("Student details have been successfully saved.");
    }

    // Method to search for a student by ID
    public static void searchStudent(ArrayList<Student> studentList, Scanner scann) {
        System.out.print("Enter Student ID to search: ");
        String id = scann.nextLine();

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.println("Student Found: ID = " + student.getId() + ", \nName = " + student.getName() + ", \nAge = " + student.getAge() + ",\nCourse = " + student.getCourse());
                return;
            }
        }

        System.out.println("Student cannot be located.");
    }
    
     // Method to edit student details
    public static void editStudentDetails(ArrayList<Student> studentList, Scanner scanner) {
        System.out.print("Enter Student ID to edit: ");
        String id = scanner.nextLine();

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.print("Enter new name (or press Enter to keep current name '" + student.getName() + "'): ");
                String newName = scanner.nextLine();
                if (!newName.isEmpty()) {
                    student.setName(newName);
                }

                int newAge;
                while (true) {
                    try {
                        System.out.print("Enter new age (or press Enter to keep current age '" + student.getAge() + "'): ");
                        String ageInput = scanner.nextLine();
                        if (ageInput.isEmpty()) break; // Keep current age
                        newAge = Integer.parseInt(ageInput);
                        if (newAge >= 16) {
                            student.setAge(newAge);
                            break; // Valid age
                        } else {
                            System.out.println("Age must be 16 or older. Please try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a valid number for age.");
                    }
                }
                
                 System.out.print("Enter new course (or press Enter to keep current course '" + student.getCourse() + "'): ");
                String newCourse = scanner.nextLine();
                if (!newCourse.isEmpty()) {
                    student.setCourse(newCourse);
                }

                System.out.println("Student details have been successfully updated.");
                return;
            }
        }

        System.out.println("Student cannot be located.");
    }

    // Method to delete a student by ID
    public static void deleteStudent(ArrayList<Student> studentList, Scanner del) {
        System.out.print("Enter Student ID to delete: ");
        String id = del.nextLine();

        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                System.out.print("Are you sure you want to delete this student? (yes/no): ");
                String confirmation = del.nextLine();
                if (confirmation.equalsIgnoreCase("yes")) {
                    studentList.remove(student);
                    System.out.println("Student has been deleted.");
                } else {
                    System.out.println("Student deletion canceled.");
                }
                return;
            }
        }

        System.out.println("Student cannot be located.");
    }

    // Method to print all student details
    public static void studentReport(ArrayList<Student> studentList) {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student Report:");
            for (Student student : studentList) {
                System.out.println("\nID: " + student.getId() + ", \nName: " + student.getName() + ", \nAge: " + student.getAge() + ", \nCourse: " + student.getCourse());
            }
        }
    }

    // Method to exit the application
    public static void exitStudentApplication() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
