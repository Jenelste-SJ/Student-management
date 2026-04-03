package org.example;

import java.sql.*;
import java.util.*;

public class StudentDAO {
    private Connection conn;

    public StudentDAO() throws Exception {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student_db", "root", "Clashofclans"
        );
    }

    public void addStudent(Student s) throws Exception {
        String query = "INSERT INTO students(name, dept, marks) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, s.getName());
        ps.setString(2, s.getDept());
        ps.setInt(3, s.getMarks());
        ps.executeUpdate();
    }

    public void viewStudents() throws Exception {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
        while (rs.next()) {
            System.out.println(rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getString("dept") + " " +
                    rs.getInt("marks"));
        }
    }

    public void deleteStudent(int id) throws Exception {
        String query = "DELETE FROM students WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public void searchByName(String name) throws Exception {
        String query = "SELECT * FROM students WHERE name LIKE ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, "%" + name + "%");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getString("name") + " " + rs.getInt("marks"));
        }
    }

    public void updateMarks(int id, int newMarks) throws Exception {
        String query = "UPDATE students SET marks=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, newMarks);
        ps.setInt(2, id);
        ps.executeUpdate();
    }
}