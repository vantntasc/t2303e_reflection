package org.aptech.t2303e.test;

public class StudentService {
    StudentRepository repo = new StudentRepository();

    public static void main(String[] args) {
        StudentService obj  = new StudentService();
        Student s = obj.repo.getById("123");
        System.err.println(s);
    }
}
