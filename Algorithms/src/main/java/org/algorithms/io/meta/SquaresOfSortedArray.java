package org.algorithms.io.meta;

import java.util.PriorityQueue;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        var minHeap = new PriorityQueue<Integer>();
        var result = new int[nums.length];
        for(int n: nums) {
            minHeap.offer((int)Math.pow(n, 2));
        }
        int index = 0;
        while(!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }
}
