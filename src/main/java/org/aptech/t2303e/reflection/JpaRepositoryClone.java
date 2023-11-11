package org.aptech.t2303e.reflection;

import java.util.List;

public interface JpaRepositoryClone<T> {
    T getById(String id);
    List<T> getAll();
    List<T> getAll(int limit , int offset);
//    Boolean insert(T t);
}
