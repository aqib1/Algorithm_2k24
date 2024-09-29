package org.algorithms.io.map.revise;


import java.util.*;
import java.util.stream.IntStream;

public class RewardSystem {

    public static void main(String[] args) {
        var reward  = new RewardSystem();
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

        System.out.println(
                reward.makePayment(
                        2, 2, 50, TransactionType.P2M
                )
        );

        System.out.println(
                reward.getNumberOfTransactions(2, TransactionType.P2P)
        );
    }

    private static final int TOP_USER = 100;
    private final Map<Integer, Integer> senderIdToTotalAmount;
    private final Map<Integer, Map<TransactionType, Integer>> senderIdToTotalTransactions;
    private final Queue<Map.Entry<Integer, Integer>> senderIdToAmountMaxHeap;
    public RewardSystem() {
        this.senderIdToTotalAmount = new HashMap<>();
        this.senderIdToTotalTransactions = new HashMap<>();
        this.senderIdToAmountMaxHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(b.getValue(), a.getValue())
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

        int index = IntStream.range(0, TOP_USER)
                .filter(i ->
                        !senderIdToAmountMaxHeap.isEmpty() &&
                                (senderId == senderIdToAmountMaxHeap.poll().getKey())
                ).findFirst()
                .orElse(-1);

        return new TransactionSummary(
                transactionId,
                index != -1
        );
    }

    public int getNumberOfTransactions(int senderId, TransactionType type) {
        return senderIdToTotalTransactions.get(senderId).get(type);
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
                if(type == TransactionType.P2M) {
                    senderIdToAmountMaxHeap.removeIf(i -> i.getKey() == senderId);
                    senderIdToAmountMaxHeap.add(
                            new AbstractMap.SimpleEntry<>(senderId, amount)
                    );
        }
    }
}
