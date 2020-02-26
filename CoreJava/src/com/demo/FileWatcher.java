package com.demo;

import java.io.File;
import java.util.Scanner;

public class FileWatcher implements Runnable {

    private long fileCount;

    private void watchFiles() { // want to use it within this class only
        File file = new File("C:\\temp");
        File files[] = file.listFiles();
        this.fileCount = files.length;
        while (true) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted in sleep ");
                // .printStackTrace();
                break;
            }

            System.out.println("Checking for changes");
            files = file.listFiles();
            if (this.fileCount != files.length) {
                System.out.println("Directory modified. new count=" + files.length);
                this.fileCount = files.length;
            }

            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread interrupted");
                break;
            } // this because we don't know the exact state of thread, so
              // interruption can be there even if the thread is not in run
              // state


        }
        /* for (File file2 : files) { System.out.println(file2.getName()); } */
    }

    public static void main(final String[] args) {

        FileWatcher watcher = new FileWatcher();
        Thread watcherThread = new Thread(watcher);
        watcherThread.start();
        Scanner scanner = new Scanner(System.in);
        String entry = scanner.nextLine();
        while (!entry.equals("stop")) {
            System.out.println("Enter stop to exit");
            entry = scanner.nextLine();
        }
        watcherThread.interrupt();
        try {
            System.out.println("Waiting for watcher to complete");
            watcherThread.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // on joining goes into block state, here main
          // will go into block state and wait for watcher to complete
        System.out.println("FileWatcher.main()..over");
    }

    public void run() {
        // TODO Auto-generated method stub
        watchFiles();

    }

}
