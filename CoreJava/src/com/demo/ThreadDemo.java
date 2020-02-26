package com.demo;

public class ThreadDemo extends Thread {

    public void run() {
        printThreadInfo();
        try {
            Thread.sleep(2000);// main thread is getting over and then daemon
                               // thread also gets over
            // here we are putting mythread to sleep
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("ThreadDemo.run()completed");
        // anything to be done with thread other than main thread should be
        // done here
    }

    private static void printThreadInfo() {

        // main thread goes on here and creation of new thread goes on here

        Thread currentThread = Thread.currentThread();
        System.out.println("ID=" + currentThread.getId());
        System.out.println("name=" + currentThread.getName());
        System.out.println("priority=" + currentThread.getPriority());
        System.out.println("state=" + currentThread.getState());
        System.out.println("daemon=" + currentThread.isDaemon());
        System.out.println("********************************");

        // background thread=demon thread; if all thread exit and daemon thread
        // exits too; if main thread gets over, all daemon thread automatically
        // get over
        // if a non daemon thread, then it needs to get over explicitly
        // priority 10 is highest priority
    }

    public static void main(final String[] args) {
        printThreadInfo();
        ThreadDemo t1 = new ThreadDemo();
        t1.setName("MyThread");
        t1.setPriority(10);
        t1.setDaemon(false);
        t1.start();// we never call run function explicitly
        try {
            Thread.sleep(5000);// whichever thread is calling t1 that will go
                               // to sleep, here main will go to sleep

        } catch (InterruptedException ex) {

        }
        System.out.println("ThreadDemo.main() completed");
    }

}
