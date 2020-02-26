package com;

public class App implements InterfaceA {

    public static void main(final String[] args) {

        App app = new App();
        app.doTask();
        app.buildTask();

    }

    public void doTask() {
        System.out.println("App.doTask()");
    }

}
