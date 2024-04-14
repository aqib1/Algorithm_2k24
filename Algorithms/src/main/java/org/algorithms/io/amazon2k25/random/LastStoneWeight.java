package org.algorithms.io.amazon2k25.random;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        var last = new LastStoneWeight();
        System.out.println(
                last.lastStoneWeight(
                        new int[] {2,7,4,1,8,1}
                )
        );
    }

    // Time complexity ON(logN) and space O(N)
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1)
            return stones[0];

        var maxHeap = new PriorityQueue<Integer>(
                Comparator.reverseOrder()
        );

        for(int stone: stones)
            maxHeap.offer(stone);

        while(maxHeap.size() >= 2) {
            int y = maxHeap.poll();
            int x = maxHeap.poll();
            if(x != y) {
                y -= x;
                maxHeap.offer(y);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
