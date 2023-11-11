package org.aptech.t2303e.test;
import org.aptech.t2303e.reflection.impl.JpaRepositoryCloneImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository extends JpaRepositoryCloneImpl<Student> {
    public StudentRepository() {
        super(Student.class);
    }
    @Override
    protected List<Student> rowMapper(ResultSet rs) {
        List<Student> students = new ArrayList<>();
        try {
            while (rs.next()){
                students.add(Student.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .address(rs.getString("address"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }
}
