package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.StampedLock;

public class StampedLockJava {
    private final List<Integer> data;
    private final StampedLock lock;
    public StampedLockJava() {
        this.lock = new StampedLock();
        this.data = new ArrayList<>();
    }

    // read contention is higher than write
    public int read(int index) {
        var optimisticStamp = this.lock.tryOptimisticRead();
        // no lock required - fast read
        if(this.lock.validate(optimisticStamp)) return data.get(index);

        // lock required - read is non-exclusive lock in stamped lock
        // means multiple read threads can enter here if no write is
        // acquired
        var readStamp = this.lock.readLock();
        try {
            return data.get(index);
        } finally {
            this.lock.unlockRead(readStamp);
        }
    }

    public void write(int data) {
        // write lock in stamped lock is exclusive lock
        // means only one thread can acquire it.
        var writeStamped = this.lock.writeLock();
        try {
            this.data.add(data);
        } finally {
            this.lock.unlockWrite(writeStamped);
        }
    }

}
