package com;

import java.io.File;
import java.util.Arrays;

interface Calculator {
    int calculate(int x, int y);
}


public class LambdaDemos {

    public static void main(final String[] args) {
        example1();
        example2();
        example3();

    }

    private static int add(final int x, final int y) {
        System.out.println("LambdaDemos.add()");
        return x + y;
    }

    private int multiply(final int x, final int y) {
        System.out.println("LambdaDemos.multiply()");
        return x * y;
    }


    private static void example3() {

        /*
         * Calculator calculator = (x, y) -> x * y; // if putting braces //
         * then typing return is // necessary
         * System.out.println(calculator.calculate(10, 20)); calculator = (x,y)
         * -> { System.out.println("LambdaDemos.example3()"); return x - y;
         *
         * };
         */
        Calculator calculator = LambdaDemos::add; // Calculate method
        // references to add method
        System.out.println(calculator.calculate(2, 3));

        LambdaDemos obj = new LambdaDemos();
        calculator = obj::multiply;
        System.out.println(calculator.calculate(2, 3));
        java.util.List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.forEach((i) -> {
            System.out.println(i);
        });


    }


    private static void example2() {
        Thread t = new Thread(() -> {
            System.out.println("Executed thread=" + Thread.currentThread().getName());
        });
        t.start();

    }


    private static void example1() {
        File files = new File("C:\\");

        // // anonymous class
        // File[] result = files.listFiles(new FileFilter() {
        //
        // public boolean accept(final File file) {
        // // TODO Auto-generated method stub
        // return file.isDirectory();
        //
        // }
        // });
        File[] result = files.listFiles((file) -> file.isDirectory());
        for (File file : result) {
            System.out.println(file.getName());
        }
    }

}
