package com.demo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import com.types.Employee;

public class CollectionDemo {

    public static void main(final String[] args) {
        setDemo();
        linkListDemo();
    }


    private static void linkListDemo() {
        // TODO Auto-generated method stub
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        for (Integer integer : numbers) {
            System.out.println(integer);

        }
        // we can use iterators also along with next and previous methods
        // we can use addfirst,addlast and all the things
        // Iterator<Integer> ite = numbers.listIterator();
        // ite.next();
        // ite.;

    }

    public static void mapDemo() {
        Map<String, String> cities = new HashMap<>();
        cities.put("India", "Delhi");
        cities.put("Germany", "Berlin");
        System.out.println(cities.get("India"));
        Set<String> keys = cities.keySet();
        for (String key : keys) {
            System.out.println(key + "=" + cities.get(key));
        }
    }


    public static void setDemo() {
        Set<String> names = new TreeSet<>(); // unordered
        names.add("Shikhar");
        names.add("Rohit");
        names.add("Virat");
        names.add("Dhoni");
        names.add("Virat");
        /*
         * for (Iterator iterator = names.iterator(); iterator.hasNext();) {
         * String name = (String) iterator.next(); System.out.println(name); }
         */

        Set<Employee> employees = new TreeSet<>(); // treeset uses compare to
        employees.add(new Employee(1, "Anil", 40000));
        employees.add(new Employee(2, "Jose", 30000));
        employees.add(new Employee(3, "Mahesh", 35000));
        employees.add(new Employee(2, "Jose", 30000));

        // for (Employee employee : employees) {
        // System.out.println("Id:" + employee.getId());
        // System.out.println("Id:" + employee.getName());
        // }

        mapDemo();

    }

}
