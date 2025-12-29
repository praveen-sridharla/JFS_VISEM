package com.example;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class App {
    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1 Insert Student");
            System.out.println("2 delete Student");
            System.out.println("3 update Student");
            System.out.println("4 display Student");
            System.out.println("5 display all Students");
            System.out.println("6 display students order by name");
            System.out.println("7 exit");
            System.err.println("Enter your choice from the above menu:");
            int opt = sc.nextInt();
            switch(opt){
                case 1:
                            System.out.println("Enter student name:");
                            String name = sc.next();
                            System.out.println("Enter student sem:");
                            int sem = sc.nextInt();
                            System.out.println("Enter student dept:");
                            String dept = sc.next();
                            Student s1 = new Student(
                                name,sem,dept
                            );
                            session.persist(s1);
                            tx.commit();
                            System.out.println("Student inserted successfully!");
                    break;
                case 2:
                    System.out.println("Enter student id to delete:");
                    int id = sc.nextInt();
                    Student s2 = session.get(Student.class, id);
                    if(s2 != null){
                        session.delete(s2);
                        tx.commit();
                        System.out.println("Student deleted successfully!");
                    } else {
                        System.out.println("Student not found with id: " + id);
                    }

                    break;
                case 3:
                    System.out.println("Enter student id to update:");
                    int uid = sc.nextInt();
                    Student s3 = session.get(Student.class, uid);
                    if(s3 != null){
                        System.out.println("Enter new name:");
                        String newName = sc.next();
                        s3.setName(newName);
                        session.update(s3);
                        tx.commit();
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found with id: " + uid);
                    }
                    break;
                case 4:
                    System.out.println("Enter student id to display:");
                    int did = sc.nextInt();
                    Student s4 = session.get(Student.class, did);
                    if(s4 != null){
                        System.out.println(s4);
                    } else {
                        System.out.println("Student not found with id: " + did);
                    }
                    break;
                case 5:
                    System.out.println("Displaying all students:");
                    List<Student> students = session.createQuery("from Student", Student.class).list();
                    for(Student s : students){
                        System.out.println(s);
                    }    

                    break;
                case 6:
                    System.out.println("Displaying all students ordered by name:");
                    List<Student> orderedStudents = session.createQuery("from Student order by name", Student.class).list();
                    for(Student s : orderedStudents){
                        System.out.println(s);
                    }

                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    session.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

