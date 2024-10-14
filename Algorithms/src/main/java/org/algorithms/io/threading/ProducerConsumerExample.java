package org.algorithms.io.threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(50);

        try (var producerExecutor = Executors.newFixedThreadPool(1);
             var consumerExecutor = Executors.newFixedThreadPool(1)) {
            producerExecutor.execute(() -> {
                for (int i = 0; i < 500; ) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    var offer = blockingQueue.offer(i);
                    if (offer) {
                        System.out.println(i + " produced by producer thread" );
                        i++;
                    }
                }
            });

            consumerExecutor.execute(() -> {
                for (int i = 0; i < 500; ) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    var offer = blockingQueue.poll();
                    if (offer != null) {
                        System.out.println(offer + " consumer by consumer thread" );
                        i++;
                    }
                }
            });
        }
    }
}
