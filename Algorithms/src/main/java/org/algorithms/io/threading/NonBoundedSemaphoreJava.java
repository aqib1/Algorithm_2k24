package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class NonBoundedSemaphoreJava {

    public static void main(String[] args) {
        var semaphoreJava = new NonBoundedSemaphoreJava(5);
        try(var readThreads = Executors.newFixedThreadPool(5);
            var writeThreads = Executors.newSingleThreadExecutor()) {
            for(int i = 0; i < 100; i++) {
                int finalI = i;
                writeThreads.execute(() -> {
                    try {
                        semaphoreJava.write(finalI);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            Thread.sleep(1000);
            for (int i = 0; i < 100; i++) {
                int finalI = i;
                readThreads.execute(() -> {
                    try {
                        System.out.println(semaphoreJava.read(finalI));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private final List<Integer> data;
    private final Semaphore readSemaphore;
    private final Semaphore writeSemaphore;
    public NonBoundedSemaphoreJava(int readPermits) {
        this.readSemaphore = new Semaphore(readPermits);
        this.data = new ArrayList<>();
        this.writeSemaphore = new Semaphore(1);
    }

    public int read(int read) throws InterruptedException {
        this.writeSemaphore.acquire();
        this.readSemaphore.acquire();
        try {
            return data.isEmpty() ?  -1 : data.get(read);
        } finally {
            this.readSemaphore.release();
            this.writeSemaphore.release();
        }
    }

    public void write(int data) throws InterruptedException {
        this.writeSemaphore.acquire();
        try {
            this.data.add(data);
        } finally {
            this.writeSemaphore.release();
        }
    }
}
