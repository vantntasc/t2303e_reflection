package org.aptech.t2303e.test;

import java.util.List;

public class StudentService {
    StudentRepository repo = new StudentRepository();

    public static void main(String[] args) {
        StudentService obj  = new StudentService();
        List<Student> students = obj.repo.getAll(3,3);
        System.err.println(students);
    }
}
