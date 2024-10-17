package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadAndWriteReentrantLocking {
    private final List<Integer> data;
    private final Lock writeLock;
    private final Lock readLock;

    public ReadAndWriteReentrantLocking() {
        ReadWriteLock reentrantLock = new ReentrantReadWriteLock();
        this.writeLock = reentrantLock.writeLock();
        this.readLock = reentrantLock.readLock();
        this.data = new ArrayList<>();
    }

    // if no thread acquiring write lock then multiple threads
    // can acquire read lock and read parallel
    public int read(int id) {
        this.readLock.lock();
        try {
            return this.data.isEmpty() ? -1 : this.data.get(id);
        } finally {
            this.readLock.unlock();
        }
    }

    // if no thread acquiring read or write lock then only
    // one thread can acquire write lock and only one can
    // do write operation at a time
    public void write(int data) {
        this.writeLock.lock();
        try {
            this.data.add(data);
        } finally {
            this.writeLock.unlock();
        }
    }
}
