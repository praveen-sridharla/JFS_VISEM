package com.example;

public class Student{
    private int id;
    private String name;
    private int sem;
    private String dept;
     Student(){

    }
    Student(String name,int sem,String dept){
        this.name=name;
        this.sem=sem;
        this.dept=dept;
    }
     Student(int id,String name,int sem,String dept){
      this.id = id;
        this.name=name;
        this.sem=sem;
        this.dept=dept;
    }
     public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return this.name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getSem() {
      return this.sem;
   }

   public void setSem(int sem) {
      this.sem=sem;
   }

   public String getDept() {
      return this.dept;
   }

   public void setDept(String dept) {
      this.dept = dept;
   }

   public String toString() {
      return "Employee [id=" + this.id + ", name=" + this.name + ", sem=" + this.sem + ", Department=" + this.dept + "]";
   }
}

