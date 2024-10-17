package org.algorithms.io.threading;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocking {

    public static void main(String[] args) {
        var reentrantLocking = new ReentrantLocking();
        reentrantLocking.writeNonReentrantWay();
    }

    public final ReentrantLock lock;
    public ReentrantLocking() {
        this.lock = new ReentrantLock(true);
    }

    public void writeReentrantWay() {
        this.lock.lock();
        try {
            System.out.println("Acquired lock by current thread - " + Thread.currentThread().getName());
            this.lock.lock();
            System.out.println("Locking again is allowed for current thread as we are implementing it in reentrant way");
        } finally {
            // because we lock twice
            this.lock.unlock();
            this.lock.unlock();
        }
    }

    public void writeNonReentrantWay() {
        this.lock.lock();
        try {
            System.out.println("Acquired lock by current thread - "+ Thread.currentThread().getName());
            if(this.lock.isHeldByCurrentThread()) {
                System.out.println("Locking again is not allowed for current thread as we are implementing it in non reentrant way");
                throw new IllegalMonitorStateException("Self deadlock avoidance");
            }
            this.lock.lock();

        } finally {
            this.lock.unlock();
        }
    }
}
