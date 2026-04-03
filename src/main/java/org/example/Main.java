package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("1.Add 2.View 3.Delete 4.Search 5.Update 6.Exit");
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
                    return;
            }
        }
    }
}