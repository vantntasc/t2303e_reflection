package org.aptech.t2303e.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.reflection.annotations.Comlumn;
import org.aptech.t2303e.reflection.annotations.Id;
import org.aptech.t2303e.reflection.annotations.Table;
import org.aptech.t2303e.reflection.consts.DataType;

import java.lang.reflect.Field;
import java.util.Date;
@Data
@AllArgsConstructor
@Builder
@Table(tableName = "student_tab le")
public class Student{
    @Id(columnName = "id", autoIncrement = false)
    private long id;
    @Comlumn(columnName = "name", type = DataType.VARCHAR)
    private String name;
    @Comlumn(columnName = "address", type = DataType.INT)
    private String address;

    public static void main(String[] args) {
//        Class<?> clazz = Student.class;
//        Table tableAnotation  = clazz.getAnnotation(Table.class);
//        if(tableAnotation != null){
//            System.err.println("class student have annotion : @table");
//            System.err.println("Table annotation of class student have tableName  :"+ tableAnotation.tableName());
//        }
//        Field[] fields = clazz.getDeclaredFields();
//        for (Field f: fields) {
////            System.err.println(f.getName());
//            Id idAnnotation = f.getAnnotation(Id.class);
//            if(idAnnotation != null){
//                System.err.println(f.getName()+ " field have id annotation");
//                System.err.println("id column name  : "+idAnnotation.tableName());
//            }
//            Comlumn columnAnnotation  = f.getAnnotation(Comlumn.class);
//            if(columnAnnotation != null){
//                System.err.println(f.getName()+ " field have column annotation");
//                System.err.println("id column name  : "+columnAnnotation.columnName());
//            }
//        }
        getSqlGetByID(Student.class);
    }

    private static void getSqlGetByID(Class clazz){
        Table tableAnotation  = (Table) clazz.getAnnotation(Table.class);
        String tableName = clazz.getSimpleName();  // if @table not have tableName value  -> tableName  = className
        if(tableAnotation != null){
           tableName = tableAnotation.tableName(); // if @table  have tableName value  -> tableName  = tableName of @table
        } else {
            // throw Exception .
            System.err.println("Class not match entity class");
        }
        String idColumnName =  "";
        Field[] fields = clazz.getDeclaredFields();
        for (Field f: fields) {
            Id idAnnotation =  f.getAnnotation(Id.class);
            if (idAnnotation != null) {
                idColumnName = idAnnotation.columnName();
                break;
            }
        }
        if(StringUtils.isEmpty(idColumnName)) // throw exception
        {
            System.err.println("id column not exist");
        }
        // return sql : select * from table_name where id_column  =  ?
        String sql  = new StringBuilder("select * from ")
                .append(tableName).append(" ").append("where")
                .append(" ").append(idColumnName).append(" = ?")
                .toString();
        System.err.println(sql);
    }

}
