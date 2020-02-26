package com.demo;

public class Counter {

    int count = 0;
    private Object monitor = new Object(); // this improves performance

    public /* synchronized */ void increment() { // to apply locks
        System.out.println(Thread.currentThread().getName() + " incrementing counter=" + this.count);
        // synchronized (this) {
        synchronized (this.monitor) {
            int temp = this.count;
            temp++;

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.count = temp;
            // }

            if (this.count == 4) {
                System.out.println(Thread.currentThread().getName() + " going to wait");
                try {
                    this.monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " released from wait");
            }
            if (this.count == 6) {
                System.out.println(Thread.currentThread().getName() + " calling notify");
                this.monitor.notify();
            }
        }
        System.out.println(Thread.currentThread().getName() + " incremented counter=" + this.count);
    }

}
