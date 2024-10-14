package org.algorithms.io.threading;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JavaExecutors {
    public void fixedThreadPool() throws InterruptedException {
        var fixedThreadPool = Executors.newFixedThreadPool(5);
        // once one thread finish it job it will pick next available task
        for(int task = 0; task < 10; task++) {
            fixedThreadPool.submit(
                    () -> {
                        for(int i = 0; i < 100; i++) {
                            System.out.println(Thread.currentThread().getName() + " executing "+ i);
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
        if(!result) {
            var pendingRunnable = fixedThreadPool.shutdownNow(); // sending request to shout down now and it will return all pending runnable
            System.out.println(pendingRunnable.size() + " Pending tasks");
            fixedThreadPool.close();
        }
    }

    public void cachedThreadPool() throws InterruptedException {
        var cachedThreadPool = Executors.newCachedThreadPool();

        // will create 20 thread in case if any thread will not able to complete its task
        // while submittion.
        for(int task = 0; task < 20; task++) {
            cachedThreadPool.submit(
                    () -> {
                        for(int i = 0; i < 500; i++) {
                            System.out.println(Thread.currentThread().getName() + " executing "+ i);
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
        cachedThreadPool.close();
    }

    public static void main(String[] args) throws InterruptedException {
        var executors = new JavaExecutors();
        executors.cachedThreadPool();
    }
}
