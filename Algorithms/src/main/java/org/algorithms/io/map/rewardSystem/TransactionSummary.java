package org.algorithms.io.map.rewardSystem;

public record TransactionSummary(
        int transactionId,
        boolean isSenderEligibleReward
) { }
