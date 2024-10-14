package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockingUsingLock {
    private final List<Integer> data;
    private final Lock lock;

    public LockingUsingLock(List<Integer> data) {
        this.data = data;
        this.lock = new ReentrantLock();
    }

    public boolean addData(int data) {
       if(this.lock.tryLock()) { // check lock is available and not acquire by read operation
           try {
               this.data.add(data);
               return true;
           } finally {
               this.lock.unlock();
           }
       } else {
            return false; // not added
       }
    }

    public int getData(int index) {
        this.lock.lock();
        try {
            if(data.size() > index) {
                return this.data.get(index);
            } else return -1;
        } finally {
            this.lock.unlock();
        }
    }

    public static void main(String[] args) {
        var stats = new ArrayList<Integer>();
        var lockingUsingReentrantLock = new LockingUsingLock(stats);
        var writerExecutor = Executors.newFixedThreadPool(5);
        var readerExecutor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            writerExecutor.execute(() -> System.out.println(lockingUsingReentrantLock.addData(finalI)));
        }

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            readerExecutor.execute(() -> System.out.println(lockingUsingReentrantLock.getData(finalI)));
        }

        writerExecutor.close();
        readerExecutor.close();
    }
}
