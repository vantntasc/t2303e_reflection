package org.aptech.t2303e.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Lab1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        getClassInfo();
    }
    private  static void getClassInfo() throws ClassNotFoundException, NoSuchMethodException {
        // get class by class name (with package)
        Class<?> clazz = Class.forName("org.aptech.t2303e.reflection.Student");
        System.err.println("Name : "+ clazz.getName());
        System.err.println("Simple Name : "+ clazz.getSimpleName());
        System.err.println("Package  :" + clazz.getPackage().getName());
        int modifider = clazz.getModifiers();
        boolean isPulbic = Modifier.isPublic(modifider);
        if(isPulbic) System.err.println("Class is public access modifier");
        // get super class
        Class<?> superClazz = clazz.getSuperclass();
        // get interface
        Class<?>[] interfaces = clazz.getInterfaces();
        for (Class<?> interfaze : interfaces) {
            System.err.println(interfaze.getSimpleName());
        }
        Constructor<?>[] constructors = clazz.getConstructors(); // get all constructor
        Method[] methods = clazz.getMethods();
        Field[] fields = clazz.getFields();
        Annotation[] annotations = clazz.getAnnotations();
    }
}
