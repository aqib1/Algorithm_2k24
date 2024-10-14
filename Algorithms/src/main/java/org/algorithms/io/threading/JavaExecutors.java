package org.algorithms.io.threading;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class JavaExecutors {
    public void fixedThreadPool() throws InterruptedException {
        try(var fixedThreadPool = Executors.newFixedThreadPool(5)) {
            // once one thread finish it job it will pick next available task
            for (int task = 0; task < 10; task++) {
                fixedThreadPool.submit(
                        () -> {
                            for (int i = 0; i < 100; i++) {
                                System.out.println(Thread.currentThread().getName() + " executing " + i);
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                );
            }

            fixedThreadPool.shutdown(); // no more task can be submitted after that
            var result = fixedThreadPool.awaitTermination(2, TimeUnit.SECONDS); // wait 2 seconds to see if tasks are finished
            if (!result) {
                var pendingRunnable = fixedThreadPool.shutdownNow(); // sending request to shout down now and it will return all pending runnable
                System.out.println(pendingRunnable.size() + " Pending tasks" );
            }
        }
    }

    public void cachedThreadPool() throws InterruptedException {
        try(var cachedThreadPool = Executors.newCachedThreadPool()) {

            // will create 20 thread in case if any thread will not able to complete its task
            // while submittion.
            for (int task = 0; task < 20; task++) {
                cachedThreadPool.submit(
                        () -> {
                            for (int i = 0; i < 500; i++) {
                                System.out.println(Thread.currentThread().getName() + " executing " + i);
                                try {
                                    Thread.sleep(1);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                );
            }

            cachedThreadPool.shutdown();
            cachedThreadPool.awaitTermination(1, TimeUnit.HOURS);
        }
    }

    public void singleThreadPool() throws InterruptedException {
        try(var singleThreadPool = Executors.newSingleThreadExecutor()) {
            singleThreadPool.execute(() -> System.out.println("Hi there"));
            singleThreadPool.shutdown();
            singleThreadPool.awaitTermination(1, TimeUnit.SECONDS);
        }
    }

    public void scheduleThreadPool() throws InterruptedException {
        AtomicInteger count = new AtomicInteger();
        var scheduleExecutor = Executors.newScheduledThreadPool(1);
        var future = scheduleExecutor.scheduleAtFixedRate(
                () -> {
                    count.getAndIncrement();
                    System.out.println("Heartbeats");
                },
                5,
                1,
                TimeUnit.SECONDS
        );
        while (true) {
            System.out.println("count :" + count.get());
            Thread.sleep(1000);
            if (count.get() == 5) {
                System.out.println("Count is 5, cancel the scheduledFuture!");
                future.cancel(true);
                scheduleExecutor.close();
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        var executors = new JavaExecutors();
        executors.scheduleThreadPool();
    }
}
