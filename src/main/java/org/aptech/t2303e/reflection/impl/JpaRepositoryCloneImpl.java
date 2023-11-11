package org.aptech.t2303e.reflection.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.config.properties.Datasource;
import org.aptech.t2303e.reflection.JpaRepositoryClone;
import org.aptech.t2303e.reflection.annotations.Id;
import org.aptech.t2303e.reflection.annotations.Table;
import org.aptech.t2303e.reflection.consts.StringSql;
import org.aptech.t2303e.test.Student;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public abstract class JpaRepositoryCloneImpl<T> implements JpaRepositoryClone<T> {
    private final String clazzName;
    private final Class<?> clazz;
    private String tableName;
    private  String idColumnName;

    protected abstract List<T> rowMapper(ResultSet rs);
    public JpaRepositoryCloneImpl(Class<?> clazz) {
        this.clazz = clazz;
        this.clazzName = clazz.getSimpleName();
        // set table name
        Table tableAnotation  = (Table) clazz.getAnnotation(Table.class);
         tableName = clazz.getSimpleName();  // if @table not have tableName value  -> tableName  = className
        if(tableAnotation != null){
            tableName = tableAnotation.tableName(); // if @table  have tableName value  -> tableName  = tableName of @table
        } else {
            // throw Exception .
            System.err.println("Class not match entity class");
        }
        // set id column name
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Id idAnnotation  = f.getAnnotation(Id.class);
            if(idAnnotation != null) this.idColumnName = idAnnotation.columnName();
        }
        if(StringUtils.isEmpty(this.idColumnName)) {
            // throw ex
        }
    }

    @Override
    public T getById(String id) {
        PreparedStatement preSt;
        String sql  = new StringBuilder(StringSql.SELECT_CLAUSE.val).append(StringSql.SPACE.val)
                .append(tableName).append(StringSql.SPACE.val).append(StringSql.WHERE.val )
                .append(StringSql.SPACE.val).append(idColumnName).append(StringSql.SPACE.val)
                .append(StringSql.SPACE.val).append(StringSql.EQUAL.val).append(StringSql.QUESTION_MARK.val)
                .append(StringSql.SEMI_COLON.val)
                .toString();
        System.err.println(sql);
        Connection conn = Datasource.getConn();
        try {
            preSt  = conn.prepareStatement(sql);
            preSt.setString(1, id);
            ResultSet rs = preSt.executeQuery();
            List<T> data = rowMapper(rs);
            if(data != null && data.size() > 0){
                return data.get(0);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    Boolean insert(T t){
        return null;
    };
}
