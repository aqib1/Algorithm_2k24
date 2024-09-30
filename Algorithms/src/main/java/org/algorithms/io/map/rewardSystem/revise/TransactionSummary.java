package org.algorithms.io.map.revise;

public record TransactionSummary(
        int transactionId,
        boolean isSenderEligibleForReward
) {
}
