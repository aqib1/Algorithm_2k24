package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Test {
    public final List<Integer> data;
    private final Lock lock1;
    private final Lock lock2;
    public Test() {
        this.data = new ArrayList<>();
        this.lock1 = new ReentrantLock();
        this.lock2 = new ReentrantLock();
    }

    public void writeOne(int data) throws InterruptedException {
        lock2.lock();
        Thread.sleep(1000);
        System.out.println("Get me the lock1...");
        lock1.lock();
        try {
            this.data.add(data);
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public void writeTwo(int data) throws InterruptedException {
        lock1.lock();
        Thread.sleep(1000);
        System.out.println("Get me the lock2.....");
        lock2.lock();
        try {
            this.data.add(data);
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
}
public class DeadLock {

    public static void main(String[] args) {
        var test = new Test();
        var t1 = new Thread(() -> {
            for(int i=0; i<10; i++) {
                try {
                    test.writeOne(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        var t2 = new Thread(() -> {
            for(int i=10; i<20; i++) {
                try {
                    test.writeTwo(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
