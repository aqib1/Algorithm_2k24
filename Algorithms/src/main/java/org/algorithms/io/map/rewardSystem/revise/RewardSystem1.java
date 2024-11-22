package org.algorithms.io.map.revise;


import org.algorithms.io.map.rewardSystem.TransactionSummary;
import org.algorithms.io.map.rewardSystem.TransactionType;

import java.util.*;

public class RewardSystem1 {

    public static void main(String[] args) {
        var reward = new RewardSystem1();
        for (int i = 0; i <= 100; i++) {
            reward.makePayment(
                    0, i + 1, 100 + i, TransactionType.P2M
            );
        }


        System.out.println(
                reward.makePayment(
                        1, 400, 2008, TransactionType.P2M
                )
        );

        System.out.println(
                reward.makePayment(
                        1, 1, 5000, TransactionType.P2P
                )
        );

        System.out.println(
                reward.getNumberOfTransactions(2, TransactionType.P2P)
        );
    }

    private static final int TOP_USER = 100;
    private final Map<Integer, Integer> senderIdToTotalAmount;
    private final Map<Integer, Map<TransactionType, Integer>> senderIdToTotalTransactions;
    private final Queue<Map.Entry<Integer, Integer>> senderIdToAmountMinHeap;

    public RewardSystem1() {
        this.senderIdToTotalAmount = new HashMap<>();
        this.senderIdToTotalTransactions = new HashMap<>();
        this.senderIdToAmountMinHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
    }

    public TransactionSummary makePayment(
            int transactionId,
            int senderId,
            int amount,
            TransactionType type
    ) {

        saveAmountForSender(
                senderId,
                amount,
                type
        );

        var found = this.senderIdToAmountMinHeap.stream()
                        .filter(entry -> entry.getKey() == senderId)
                        .findAny()
                        .orElse(null);

        return new TransactionSummary(
                transactionId,
                found != null
        );
    }

    public int getNumberOfTransactions(int senderId, TransactionType type) {
        return senderIdToTotalTransactions.getOrDefault(
                senderId, Map.of()
        ).getOrDefault(type, 0);
    }

    private void saveAmountForSender(int senderId, int amount, TransactionType type) {
        var transactionAmount =
                senderIdToTotalTransactions.getOrDefault(senderId, new HashMap<>());

        transactionAmount.put(
                type,
                transactionAmount.getOrDefault(type, 0) + 1
        );

        senderIdToTotalTransactions.put(senderId, transactionAmount);

        senderIdToTotalAmount.put(
                senderId,
                senderIdToTotalAmount.getOrDefault(senderId, 0) + amount
        );

        prepareMaxHeap(senderId, senderIdToTotalAmount.get(senderId), type);
    }

    private void prepareMaxHeap(int senderId, int amount, TransactionType type) {
        if (type == TransactionType.P2M) {
            senderIdToAmountMinHeap.removeIf(i -> i.getKey() == senderId);
            senderIdToAmountMinHeap.add(
                    new AbstractMap.SimpleEntry<>(senderId, amount)
            );

            if(senderIdToAmountMinHeap.size() > TOP_USER) {
                senderIdToAmountMinHeap.poll();
            }
        }
    }
}
