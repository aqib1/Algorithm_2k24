package org.algorithms.io.arrays.revision;

import java.util.Comparator;
import java.util.PriorityQueue;

public class CountPartitions {

    public static void main(String[] args) {
        System.out.println(
                countPartitions(
                        new int[]{3, 2, 1, 3, 1},
                        new int[]{3, 5, 3, 5, 5}
                )
        );
    }

    //
    public static int countPartitions(int[] used, int[] totalCapacity) {
        var maxHeap = new PriorityQueue<Integer>(
                Comparator.reverseOrder()
        );

        for(var total: totalCapacity) maxHeap.offer(total);

        var totalUsed = 0;
        for(var use: used) totalUsed += use;

        var countPartitions = 0;
        while(!maxHeap.isEmpty()) {
            totalUsed -= maxHeap.poll();
            countPartitions++;
            if(totalUsed <= 0) break;
        }

        return countPartitions;
    }
}
