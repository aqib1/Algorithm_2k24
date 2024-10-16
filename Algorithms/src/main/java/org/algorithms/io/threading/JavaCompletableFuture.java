package org.algorithms.io.threading;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class JavaCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture as future
        var completableFuture1 = new CompletableFuture<String>();

        try (var executor = Executors.newSingleThreadExecutor()) {
            executor.submit(() -> {
                System.out.println("Waiting...");
                Thread.sleep(10000);
                completableFuture1.complete("This is completed" );
                return null;
            });

            System.out.println(completableFuture1.get());
        }

        var completableFuture = CompletableFuture.completedFuture("Test");
        System.out.println(completableFuture.get());
        var futures = new ArrayList<CompletableFuture<Boolean>>();
        for(int i = 1; i < 10; i++) {
            int finalI = i;
            futures.add(CompletableFuture.supplyAsync(() -> {
                for(int j = 1; j <= 10; j++) {
                    System.out.println(finalI + " X "+ j + " = " + (finalI * j));
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return true;
            }));
        }

        for(var future : futures) System.out.println(future.get());

        var completableFuture2 = CompletableFuture.supplyAsync(
                () -> "Hello"
        );

        completableFuture2 = completableFuture2.thenApply(data -> data + " World");

        System.out.println(completableFuture2.get());
        var voidFuture = completableFuture2.thenAccept(System.out::println);
        voidFuture.get();

       completableFuture2 = completableFuture2.thenCompose(s ->
                CompletableFuture.supplyAsync(() -> s + " World"));

        System.out.println(completableFuture2.get());
    }
}
