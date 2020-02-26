package com.demo;

import java.lang.reflect.Method;

import com.app.Line;

public class ReflectionDemo {

    public static void main(final String args[]) {
        // runtimeinfo();
        runtimeObjectCreation();
    }

    private static void runtimeObjectCreation() {
        // TODO Auto-generated method stub

        try {

            Class clazz = Class.forName("com.types.Employee");
            Object obj = clazz.newInstance();
            System.out.println("Class name=" + obj.getClass().getName());

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    private static void runtimeinfo() {
        // TODO Auto-generated method stub
        Object obj = new Line();

        Class clazz = obj.getClass();
        System.out.println("Name=" + clazz.getName());
        System.out.println("Simple Name=" + clazz.getSimpleName());

        Method[] methods = clazz.getMethods();
        System.out.println("Printing methods------------------");// it shows
                                                                 // methods for
                                                                 // that class
                                                                 // and object
                                                                 // class
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }

}
