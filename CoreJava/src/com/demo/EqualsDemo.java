package com.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.types.Employee;

public class EqualsDemo {

    public static void main(final String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        /*
         * System.out.println(s1 == s2); // compares the references
         * System.out.println(s1 == s3);
         *
         * System.out.println("EqualsDemo.main()");
         *
         * System.out.println(s1.equals(s2)); // compares the objects(value)
         * System.out.println(s1.equals(s3));
         *
         * System.out.println("EqualsDemo.main()");
         */

        Employee e1 = new Employee(1, "Anil", 40000);
        Employee e2 = new Employee(2, "Sachin", 50000);
        Employee e3 = new Employee(1, "Anil", 40000);
        Employee e4 = e1; // pointing to same object
        Employee e5 = new Employee(3, "Anilmabani", 3500);


        /*
         * System.out.println("EqualsDemo.main()");
         *
         * System.out.println(e1 == e2); System.out.println(e1 == e3);
         * System.out.println(e1 == e4);
         *
         * System.out.println("EqualsDemo.main()");
         *
         * System.out.println(e1.equals(e2));
         * System.out.println(e1.equals(e3));// important: this is also based
         * on // reference checking, therefore we // have to provide our own //
         * implementation of equals System.out.println(e1.equals(e4));
         *
         * System.out.println("EqualsDemo.main()");
         * System.out.println(e1.hashCode());
         * System.out.println(e2.hashCode());
         * System.out.println(e3.hashCode());
         * System.out.println(e4.hashCode());
         */
        List<Employee> employees = new ArrayList<>();
        employees.add(e5);
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        System.out.println("Before sort---");

        for (Employee employee : employees) {
            System.out.println(employee.getId());

        }

        System.out.println("After sort---");

        Collections.sort(employees);

        for (Employee employee : employees) {
            System.out.println(employee.getId());
            System.out.println(employee.getName());

        }

        System.out.println("EqualsDemo.main()");

        Collections.sort(employees, new Comparator<Employee>() {

            public int compare(final Employee o1, final Employee o2) {
                // TODO Auto-generated method stub
                return o1.getName().compareToIgnoreCase(o2.getName());

            }

        });

        for (Employee employee : employees) {
            System.out.println(employee.getId());
            System.out.println(employee.getName());

        }


    }

}
