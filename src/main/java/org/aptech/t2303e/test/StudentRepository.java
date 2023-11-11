package org.aptech.t2303e.test;

import org.aptech.t2303e.reflection.JpaRepositoryClone;
import org.aptech.t2303e.reflection.impl.JpaRepositoryCloneImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRepository implements JpaRepositoryClone {
    JpaRepositoryClone repo = new JpaRepositoryCloneImpl(Student.class) {
        @Override
        protected Student rowMapper(ResultSet rs) {
            try {
                return Student.builder()
                        .id(rs.getLong("id_column"))
                        .name(rs.getString("name"))
                        .address(rs.getString("address"))
                        .build();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    };
    @Override
    public Student getById(String id) {
        return null;
    }
    Student rowMapper(ResultSet rs) {
        try {
            return Student.builder()
                    .id(rs.getLong("id_column"))
                    .name(rs.getString("name"))
                    .address(rs.getString("address"))
                    .build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
