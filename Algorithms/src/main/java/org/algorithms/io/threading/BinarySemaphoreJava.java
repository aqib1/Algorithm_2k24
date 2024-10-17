package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class BinarySemaphoreJava {

    public static void main(String[] args) {
        var semaphoreJava = new BinarySemaphoreJava();
        try(var readThreads = Executors.newFixedThreadPool(15);
            var writeThreads = Executors.newSingleThreadExecutor()) {
            for(int i = 0; i < 200; i++) {
                int finalI = i;
                writeThreads.execute(() -> {
                    try {
                        semaphoreJava.write(finalI);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            Thread.sleep(2000);
            for (int i = 0; i < 200; i++) {
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
    private final Semaphore semaphore;
    public BinarySemaphoreJava() {
        this.data = new ArrayList<>();
        this.semaphore = new Semaphore(1);
    }

    public int read(int read) throws InterruptedException {
        this.semaphore.acquire();
        try {
            return data.isEmpty() ?  -1 : data.get(read);
        } finally {
            this.semaphore.release();
        }
    }

    public void write(int data) throws InterruptedException {
        this.semaphore.acquire();
        try {
            this.data.add(data);
        } finally {
            this.semaphore.release();
        }
    }
}
