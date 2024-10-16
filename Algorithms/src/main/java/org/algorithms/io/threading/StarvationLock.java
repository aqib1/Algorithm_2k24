package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StarvationLock {
    public final List<Integer> data;
    private final Lock lock;
    public StarvationLock() {
        this.lock = new ReentrantLock();
        this.data = new ArrayList<>();
    }

    public void writeData(int data) {
        lock.lock();
        try {
            while(true) {
                this.data.add(data);
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName() + " is running.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        var starvationLock = new StarvationLock();

        for(int x = 0; x < 10; x++) {
            int finalX = x;
            new Thread(() -> starvationLock.writeData(finalX)).start();
        }
    }
}
