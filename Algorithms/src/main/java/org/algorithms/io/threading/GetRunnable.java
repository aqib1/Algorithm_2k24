package org.algorithms.io.threading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class GetRunnable implements Runnable {

    private final AtomicInteger random = new AtomicInteger();

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
            random.set(ThreadLocalRandom.current().nextInt(1, 1000));
            synchronized (this) {
                notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer get() throws InterruptedException {
        synchronized (this) {
            if (random.get() == 0) {
                wait();
            }
        }
        return random.get();
    }
}

//FutureTask like behaviour
class ThreadWaitAndNotifyAll1 {
    public static void main(String[] args) throws InterruptedException {
        var getRunnable = new GetRunnable1();
        var thread = new Thread(getRunnable);
        thread.start();

        // blocking call.
        System.out.println(getRunnable.get());
        System.out.println("Bye");
    }
}
