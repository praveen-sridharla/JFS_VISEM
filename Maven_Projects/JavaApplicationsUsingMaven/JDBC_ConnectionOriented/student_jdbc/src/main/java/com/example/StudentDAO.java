package com.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentDAO {


private static final String URL ="jdbc:mysql://localhost:3306/skillnext_db";
private static final String USER = "root";
private static final String PASSWORD = "root";


public StudentDAO() {
      try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      System.out.println("MySQL Driver Loaded");
      } catch (ClassNotFoundException e) {
      e.printStackTrace();
      }
}


// INSERT
public void addStudent(Student std) throws Exception {
String sql = "INSERT INTO student (name, sem, dept) VALUES (?, ?, ?)";


try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement stmt = conn.prepareStatement(sql)) {


      stmt.setString(1, std.getName());
      stmt.setInt(2, std.getSem());
      stmt.setString(3, std.getDept());
      stmt.executeUpdate();
      System.out.println("Student added successfully");
   }
}


// SELECT ALL
public List<Student> getAllStudents() throws Exception {
List<Student> list = new ArrayList<>();


try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
Statement stmt = conn.createStatement();
ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {


while (rs.next()) {
Student s = new Student();
s.setId(rs.getInt("id"));
s.setName(rs.getString("name"));
s.setSem(rs.getInt("sem"));
s.setDept(rs.getString("dept"));
list.add(s);
}
}
return list;
}


// DELETE
public void deleteStudent(int id) throws Exception {
String sql = "DELETE FROM student WHERE id = ?";


try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement stmt = conn.prepareStatement(sql)) {


stmt.setInt(1, id);
stmt.executeUpdate();
System.out.println("Student deleted successfully");
}
}


// UPDATE
public void updateStudent(Student std) throws Exception {
String sql = "UPDATE student SET name = ?, sem = ?, dept = ? WHERE id = ?";


try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
PreparedStatement stmt = conn.prepareStatement(sql)) {


stmt.setString(1, std.getName());
stmt.setInt(2, std.getSem());
stmt.setString(3, std.getDept());
stmt.setInt(4, std.getId());


stmt.executeUpdate();
System.out.println("Student updated successfully");
}
}


// EXISTS
public boolean exists(int id) throws Exception {
      String sql = "SELECT 1 FROM student WHERE id = ?";


      try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql)) {


            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next();
      }
      }
public void countStudentsByDeptDesc() throws Exception {
    String sql = 
        "SELECT dept, COUNT(id) AS total_students " +
        "FROM student " +
        "GROUP BY dept " +
        "ORDER BY total_students DESC";

    try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        System.out.println("\nDepartment-wise Student Count (Descending)");
        System.out.println("-----------------------------------------");

        while (rs.next()) {
            String dept = rs.getString("dept");
            int count = rs.getInt("total_students");
            System.out.println(dept + " : " + count);
        }
    }
}

}