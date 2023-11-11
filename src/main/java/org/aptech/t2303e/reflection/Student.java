package org.aptech.t2303e.reflection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
@Data
@AllArgsConstructor
public class Student implements Human,Animal {
    private long id;
    private String name;
    private Date dateOfBirth;
    private String address;
}
