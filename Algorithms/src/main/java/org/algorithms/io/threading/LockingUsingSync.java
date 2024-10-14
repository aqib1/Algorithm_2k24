package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class LockingUsingSync {
    private final List<Integer> data;

    public LockingUsingSync(List<Integer> data) {
        this.data = data;
    }

    public synchronized void addData(int data) {
        this.data.add(data);
    }

    public synchronized int getData(int index) {
        return this.data.get(index);
    }

    public static void main(String[] args) {
        var data = new ArrayList<Integer>();
        var lockingUsingSync = new LockingUsingSync(data);
        var writerExecutor = Executors.newFixedThreadPool(10);
        var readerExecutor = Executors.newFixedThreadPool(10);

        for(int i = 0; i < 100; i++) {
            int finalI = i;
            writerExecutor.execute(() -> lockingUsingSync.addData(finalI));
        }

        for(int i = 0; i < 100; i++) {
            int finalI = i;
            readerExecutor.execute(() -> System.out.println(lockingUsingSync.getData(finalI)));
        }

        writerExecutor.close();
        readerExecutor.close();
    }
}
