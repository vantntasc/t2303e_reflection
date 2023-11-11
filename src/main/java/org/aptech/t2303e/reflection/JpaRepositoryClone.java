package org.aptech.t2303e.reflection;

public interface JpaRepositoryClone<T> {
    T getById(String id);
    Boolean insert(T t);
}
