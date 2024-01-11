package org.algorithms.io.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestFromStream {
    private final Queue<Integer> minHeap;
    private final int k;


    // Time complexity ONLog(K) as we are only adding K elements
    // Space complexity O(K)
    public KthLargestFromStream(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>(k);
        this.k = k;
        for(int n: nums) {
            add(n);
        }
    }

    // Time complexity OLog(n) where add is called n times
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.offer(val);
        } else if(val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }

        return minHeap.peek();
    }
}
