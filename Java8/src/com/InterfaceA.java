package com;

@FunctionalInterface
public interface InterfaceA {

    void doTask();

    default void buildTask() {
        System.out.println("InterfaceA.buildTask()");
    }

    static void staticTask() {
        System.out.println("InterfaceA.staticTask()");
    }

}
