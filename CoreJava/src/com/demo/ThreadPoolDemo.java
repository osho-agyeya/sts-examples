package com.demo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    static class MyTask implements Runnable {

        private int taskId;

        public MyTask(final int taskId) {
            this.taskId = taskId;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + " processing task=" + this.taskId);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " processing task=" + this.taskId);
        }

    }

    public static void main(final String[] args) {

        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 5, TimeUnit.SECONDS, workQueue);

        // task to execute

        for (int i = 0; i < 20; i++) {
            executor.execute(new MyTask(i));
        }

        executor.shutdown();

        try {
            executor.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("ThreadPoolDemo.main()");

        // it gives output 20 times

    }

}
