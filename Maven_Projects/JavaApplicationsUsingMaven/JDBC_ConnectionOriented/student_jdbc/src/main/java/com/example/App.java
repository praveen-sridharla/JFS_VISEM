// package com.example;

// /**
//  * Hello world!
//  *
//  */
// public class App 
// {
//     public static void main( String[] args )
//     {
//         System.out.println( "Hello World!" );
//     }
// }

// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package com.example;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class App {
   public App() {
   }

   public static void main(String[] args) {
      try {
         StudentDAO dao = new StudentDAO();
            Scanner sc = new Scanner(System.in);
            int id;
            String name;
            int sem;
            String dept;
            while (true) { 
                System.err.println("1.Insert Student");
                System.err.println("2.Update Student");
                System.err.println("3.Delete Student");
                System.err.println("4.View all Studnets");
                System.err.println("5.Did the Student exist");
                System.err.println("6.Count the no.of Students in each dept");
                System.err.println("7.exit");
                System.err.println("Enter a option from the above :");
                int opt = sc.nextInt();
                sc.nextLine(); // consume newline
                switch(opt){
                    case 1:
                       System.out.print("Enter name: ");
                        name = sc.nextLine();


                        System.out.print("Enter semester: ");
                        sem = sc.nextInt();
                        sc.nextLine();


                        System.out.print("Enter department: ");
                        dept = sc.nextLine();


                        Student s1 = new Student(name, sem, dept);
                        dao.addStudent(s1);

                        break;
                    case 2:
                       System.out.print("Enter ID to update: ");
                        id = sc.nextInt();
                        sc.nextLine();


                        System.out.print("Enter new name: ");
                        name = sc.nextLine();


                        System.out.print("Enter new semester: ");
                        sem = sc.nextInt();
                        sc.nextLine();


                        System.out.print("Enter new department: ");
                        dept = sc.nextLine();


                        Student s2 = new Student(id,name, sem, dept);
                        dao.updateStudent(s2);
                        break;
                    case 3:
                         System.out.print("Enter ID to delete: ");
                            id = sc.nextInt();
                            dao.deleteStudent(id);
                        break;
                    case 4:
                             List<Student> students = dao.getAllStudents();
                            System.out.println("\n--- Student List ---");
                            Iterator<Student> it = students.iterator();
                            while (it.hasNext()) {
                            System.out.println(it.next());
                            }
                        break;
                    case 5:
                        System.out.print("Enter ID to check: ");
                        id = sc.nextInt();
                        if (dao.exists(id)) {
                        System.out.println("Student with ID " + id + " exists");
                        } else {
                        System.out.println("Student with ID " + id + " does not exist");
                        }
                        break;
                            
                    case 6:
                        dao.countStudentsByDeptDesc();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        System.exit(0);
                        break;
                    default:
                        System.err.println("selected option is not in the options!");
                        break;
                }
            }

      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
