package org.aptech.t2303e.reflection.annotations;

import org.aptech.t2303e.reflection.consts.DataType;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Comlumn {
    String columnName();
    DataType type();
}
