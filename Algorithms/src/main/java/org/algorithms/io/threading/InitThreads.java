package org.algorithms.io.threading;


import java.util.concurrent.Executors;

public class InitThreads extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if (isInterrupted()) {
                System.out.println("Interrupted, breaking" );
                break;
            }
            System.out.println("Hi there = " + i);
        }
    }

    public static void main(String[] args) {
        var example = new InitThreads();
        example.start();
        example.interrupt();

        var singleExecutor = Executors.newSingleThreadExecutor();
            for(int i = 0 ; i < 5; i++) {
                int finalI1 = i;
                singleExecutor.submit(() -> {
                    try {
                        sleep(100);
                        System.out.println(Thread.currentThread().getName() + " -> "+ finalI1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        singleExecutor.close();

        var fixedExecutor = Executors.newFixedThreadPool(1);
        for(int i = 0 ; i < 100; i++) {
            int finalI1 = i;
            fixedExecutor.submit(() -> {
                try {
                    sleep(100);
                    System.out.println(Thread.currentThread().getName() + " -> "+ finalI1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        fixedExecutor.close();
    }
}
