package org.algorithms.io.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadWithFutureTask {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // future task take callable
        var futureTask = new FutureTask<>(() -> {
            Thread.sleep(5000);
            return 0;
        });

        // thread class can not work directly with
        // callable
        var thread = new Thread(
            futureTask
        );
        thread.start();


        System.out.println(futureTask.get()); // blocking call

        // this will not print until future task return
        System.out.println("Bye");
    }
}
