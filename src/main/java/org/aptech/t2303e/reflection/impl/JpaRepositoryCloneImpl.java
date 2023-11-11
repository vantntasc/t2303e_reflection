package org.aptech.t2303e.reflection.impl;

import org.apache.commons.lang3.StringUtils;
import org.aptech.t2303e.reflection.JpaRepositoryClone;
import org.aptech.t2303e.reflection.annotations.Id;
import org.aptech.t2303e.reflection.annotations.Table;
import org.aptech.t2303e.reflection.consts.StringSql;
import org.aptech.t2303e.test.Student;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public abstract class JpaRepositoryCloneImpl<T> implements JpaRepositoryClone<T> {
    private final String clazzName;
    private final Class<?> clazz;
    private String tableName;
    private  String idColumnName;

    protected abstract Student rowMapper(ResultSet rs);
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
        Field[] fields = clazz.getFields();
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
        String sql  = new StringBuilder(StringSql.SELECT_CLAUSE.val)
                .append(tableName).append(StringSql.SPACE.val).append(StringSql.WHERE.val )
                .append(StringSql.SPACE.val).append(idColumnName).append(StringSql.SPACE.val)
                .append(StringSql.EQUAL).append(StringSql.SPACE.val).append(StringSql.EQUAL.val)
                .toString();
        return null;
    }
}
