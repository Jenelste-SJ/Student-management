package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n====================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("====================================");
            System.out.println(" 1 -> Add Student");
            System.out.println(" 2 -> View Students");
            System.out.println(" 3 -> Delete Student");
            System.out.println(" 4 -> Search Student");
            System.out.println(" 5 -> Update Marks");
            System.out.println(" 6 -> Top Performers");
            System.out.println(" 7 -> Exit");
            System.out.println("====================================");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String name = sc.next();
                    System.out.print("Dept: ");
                    String dept = sc.next();
                    System.out.print("Marks: ");
                    int marks = sc.nextInt();

                    if (marks < 0 || marks > 100) {
                        System.out.println("Invalid marks!");
                        break;
                    }

                    dao.addStudent(new Student(name, dept, marks));
                    break;

                case 2:
                    dao.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter name: ");
                    dao.searchByName(sc.next());
                    break;

                case 5:
                    System.out.print("Enter id: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new marks: ");
                    int newMarks = sc.nextInt();
                    dao.updateMarks(id, newMarks);
                    break;

                case 6:
                    dao.topStudents();
                    break;

                case 7:
                    return;
            }
        }
    }
}