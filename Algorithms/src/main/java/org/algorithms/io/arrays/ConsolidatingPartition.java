package org.algorithms.io.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ConsolidatingPartition {
    public static void main(String[] args) {
        System.out.println(
                consolidatingPartition(
                        new int[]{2, 2, 3},
                        new int[]{3, 3, 3}
                )
        );
    }

    // Time complexity O(n * Log(n))
    // Space complexity O(n)
    public static int consolidatingPartition(
            int[] used,
            int[] totalCapacity
    ) {
        var maxHeap = new PriorityQueue<Integer>(
                Comparator.reverseOrder()
        );

        for (int total : totalCapacity) maxHeap.offer(total);

        int totalUsed = 0;
        for (var u : used) totalUsed += u;

        int countPartition = 0;
        for (int i = 0; i < totalCapacity.length && !maxHeap.isEmpty(); i++) {
            totalUsed -= maxHeap.poll();
            countPartition++;
            if (totalUsed <= 0) break;
        }
        return countPartition;
    }
}
