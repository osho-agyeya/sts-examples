package com.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizationDemo implements Runnable

{

    private Counter counter;

    public SynchronizationDemo(final Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            this.counter.increment();
        }
    }

    public static void main(final String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        Counter counter = new Counter();

        service.execute(new SynchronizationDemo(counter));
        service.execute(new SynchronizationDemo(counter));
        service.shutdown();

        try {
            service.awaitTermination(200, TimeUnit.SECONDS);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("SynchronizationDemo.main()" + counter.count);


    }

}
