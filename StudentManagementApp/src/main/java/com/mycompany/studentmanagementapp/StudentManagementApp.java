/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmanagementapp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
// Main application to manage user interaction and control flow
public class StudentManagementApp {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("\nSTUDENT MANAGEMENT APPLICATION");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            String input = scan.nextLine();

            if (!input.equals("1")) {
                Student.exitStudentApplication();
            }

            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Edit a student.");
            System.out.println("(4) Delete a student.");
            System.out.println("(5) Print student report.");
            System.out.println("(6) Exit Application.");
           
            // Get user choice
            String choice = scan.nextLine();

            switch (choice) {
                case "1":
                    Student.saveStudent(studentList, scan);
                    break;
                case "2":
                    Student.searchStudent(studentList, scan);
                    break;
                case "3":
                    Student.editStudentDetails(studentList, scan);
                    break;
                case "4":
                    Student.deleteStudent(studentList, scan);
                    break;
                case "5":
                    Student.studentReport(studentList);
                    break;
                case "6":
                    Student.exitStudentApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
