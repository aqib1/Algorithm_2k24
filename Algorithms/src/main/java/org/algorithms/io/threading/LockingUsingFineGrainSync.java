package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class LockingUsingFineGrainSync {

    private final List<Integer> data;
    private final Object lock;

    public LockingUsingFineGrainSync(List<Integer> data) {
        this.data = data;
        this.lock = new Object();
    }

    public void addData(int data) {
        synchronized (lock) {
            this.data.add(data);
        }
    }

    public int getData(int index) {
        synchronized (lock) {
            return this.data.get(index);
        }
    }

    public static void main(String[] args) {
        var values = new ArrayList<Integer>();
        var lockingUsingFineGrainSync = new LockingUsingFineGrainSync(values);
        var writerExecutor = Executors.newFixedThreadPool(20);
        var readerExecutor = Executors.newFixedThreadPool(20);

        for(int i = 0; i < 200; i++) {
            int finalI = i;
            writerExecutor.execute(() -> lockingUsingFineGrainSync.addData(finalI));
        }

        for(int i = 0; i < 200; i++) {
            int finalI = i;
            readerExecutor.execute(() -> System.out.println(lockingUsingFineGrainSync.getData(finalI)));
        }

        writerExecutor.close();
        readerExecutor.close();
    }
}
