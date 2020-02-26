package com.demo;

import java.util.ArrayList;
import java.util.List;

import com.types.Employee;


class Box<T> {// multiple generics are also allowed
    T data;

    public Box(final T data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }

    T get() {
        return this.data;
    }
}


class NumberBox<T extends Number> {// only numbers allowed therefore bounded
                                   // type
    T data;

    public NumberBox(final T data) {
        // TODO Auto-generated constructor stub
        this.data = data;
    }

    T get() {
        return this.data;
    }
}


public class GenericsDemo {

    public static void main(final String[] args) {
        // non generics
        List list = new ArrayList<>();
        list.add(100); // actual is Integer
        list.add(200);
        list.add("300");

        int val = (int) list.get(0);
        // System.out.println(val);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(100);
        numbers.add(200);
        int number = numbers.get(0);
        // System.out.println(number);

        Box<String> box1 = new Box<>("abc");
        // System.out.println("box 1=" + box1.get());

        Box<Integer> box2 = new Box<>(100);
        // System.out.println("box 2=" + box2.get());

        NumberBox<Integer> nbox1 = new NumberBox<>(100);
        NumberBox<Float> nbox2 = new NumberBox<>(100.f);
        // NumberBox<String> nbox1 = new NumberBox<>("hello");

        Object obj = new Employee();

        Number n = new Integer(100);

        // List<Number> listNumbers = new ArrayList<Integer>();
        print(numbers);// doesn't allow

    }

    // wildcard
    public static void print(final List<? extends Number> numbers) {
        System.out.println("************************************");
        for (Number number : numbers) {
            System.out.println(number);
        }
    }


}
