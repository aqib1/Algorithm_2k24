package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class WaitRunnable implements Runnable {
    private Boolean isFinished = false;
    @Override
    public void run() {
        System.out.println("I am waiting....");
        try {
            Thread.sleep(5000);
            System.out.println("Bye");
            isFinished = true;
            synchronized (this) {
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean get() throws InterruptedException {
        if(!isFinished) {
            synchronized (this) {
                wait();
            }
        }

        return isFinished;
    }
}

public class ThreadRevision {

    public static void scheduleExecutor() {
        AtomicInteger count = new AtomicInteger(0);
        try(var alarm = Executors.newScheduledThreadPool(1)) {
            var future = alarm.scheduleAtFixedRate(
                    () -> {
                        System.out.println("Adisa I Love you twink twink!!");
                        count.addAndGet(1);
                    },
                    0,
                    2,
                    TimeUnit.SECONDS
            );

            while(true) {
                Thread.sleep(20);
                if(count.get() == 5) {
                    future.cancel(true);
                    break;
                }
            }
        } catch (InterruptedException e) {

        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        scheduleExecutor();

        //        var futureTask = new FutureTask<>(() -> {
//            System.out.println("I am waiting....");
//            Thread.sleep(5000);
//            System.out.println("Bye");
//            return 0;
//        });
//        var runnable = new WaitRunnable();
//        var thread = new Thread(runnable);
//        thread.start();
//
//        System.out.println(runnable.get()); // will block execution
//        System.out.println("Hi there");

        // java 1.5
        try (var fixedThreadPool = Executors.newFixedThreadPool(1)) {
            var futures = new ArrayList<Future<Boolean>>();
            for (int i = 0; i < 10; i++) {
                futures.add(fixedThreadPool.submit(() -> {
                    for (int a = 1; a <= 10; a++) {
                        System.out.println("2 X " + a + " = " + (2 * a));
                    }
                    System.out.println("\n" );
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // no need
                    }

                    return true;
                }));
            }

            futures.forEach(f -> {
                try {
                    System.out.println(f.get());
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            });
        }

//            fixedThreadPool.shutdown();
//            var awaited = fixedThreadPool.awaitTermination(1, TimeUnit.SECONDS);
//            if(!awaited) {
//                var remainWork = fixedThreadPool.shutdownNow();
//                System.out.println("Request for shutdown too early");
//            }
//        }

        // 100
//        try(var cachedThreadPool = Executors.newCachedThreadPool()) {
//            for(int i = 0; i < 100; i++) {
//                if(i % 5 == 0) {
//                    Thread.sleep(10000);
//                }
//                // 5 (5 seconds) (5 )
//                cachedThreadPool.execute(() -> {
//                    // doing some work
//
//                    // 1 sec
//                });
//            }
//        }

        // ->
        // ->          // -> -> ->
        // ->
//        try(var singleThreadPool = Executors.newSingleThreadExecutor()) {
//            singleThreadPool.execute(() -> {
//
//            });
//        }


    }
}
