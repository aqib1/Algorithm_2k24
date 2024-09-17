package org.algorithms.io.map.rewardSystem;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaRewardSystem {

    public static void main(String[] args) {
        var reward  = new JavaRewardSystem();
        System.out.println(
                reward.makePayment(
                    0, 2, 100, TransactionType.P2P
                )
        );

        System.out.println(
                reward.makePayment(
                        1, 4, 18, TransactionType.P2M
                )
        );
    }

    private final Lock lock;
    private final Map<Integer, Map<TransactionType, Integer>> userIdToTotalAmount;
    private final Queue<Map.Entry<Integer, Integer>> userIdToAmountMaxHeap;

    public JavaRewardSystem() {
        this.lock = new ReentrantLock();
        this.userIdToTotalAmount = new HashMap<>();
        this.userIdToAmountMaxHeap = new PriorityQueue<>(
                (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())
        );
    }

    public TransactionSummary makePayment(
            int transactionId,
            int senderId,
            int amount,
            TransactionType type
    ) {
        lock.lock();
        try {
            prepareUserIdToTotalAmountMap(senderId, amount, type);

            var found =
                    this.userIdToAmountMaxHeap.stream()
                            .filter(entry -> entry.getKey() == senderId)
                            .findAny()
                            .orElse(null);

            return new TransactionSummary(
                    transactionId,
                    found != null
            );
        } finally {
            this.lock.unlock();
        }
    }

    private void prepareUserIdToTotalAmountMap(
            int senderId,
            int amount,
            TransactionType type
    ) {
        var userTypeByTotalAmount =
                this.userIdToTotalAmount.getOrDefault(
                        senderId,
                        new ConcurrentHashMap<>()
                );

        userTypeByTotalAmount.put(
                type,
                userTypeByTotalAmount.getOrDefault(
                        type,
                        0
                ) + amount
        );

        this.userIdToTotalAmount.put(
                senderId,
                userTypeByTotalAmount
        );

        prepareMaxHeapForTop100Users();
    }

    private void prepareMaxHeapForTop100Users() {
        for (var userId : this.userIdToTotalAmount.keySet()) {
            var amountAgainstTransType =
                    this.userIdToTotalAmount.get(userId);
            for (var transType : amountAgainstTransType.keySet()) {
                if (transType == TransactionType.P2M) {
                    addOrUpdateTopUser(userId, amountAgainstTransType.get(transType));
                }
            }
        }
    }

    private void addOrUpdateTopUser(int senderId, int totalAmount) {
        this.userIdToAmountMaxHeap.removeIf(
                entry -> entry.getKey() == senderId
        );
        this.userIdToAmountMaxHeap.offer(
                new AbstractMap.SimpleEntry<>(senderId, totalAmount)
        );

        if (userIdToAmountMaxHeap.size() > 100)
            userIdToAmountMaxHeap.poll();
    }
}
