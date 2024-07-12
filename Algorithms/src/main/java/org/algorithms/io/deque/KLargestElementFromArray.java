package org.algorithms.io.deque;

import java.util.PriorityQueue;

public class KLargestElementFromArray {
    public static void main(String[] args) {
        var kth = new KLargestElementFromArray();
        System.out.println(
                kth.findKthLargest(
                        new int[] {3,2,1,5,6,4},
                        4
                )
        );
    }

    // time complexity = n * (log n)
    // space complexity = O(n) where n is nums length
    public int findKthLargest(int[] nums, int k) {
        // to avoid complexity for heapify pass initial
        // capacity as nums length, a small optimisation.
        var maxHeap = new PriorityQueue<Integer>(
                nums.length,
                (a, b) -> Integer.compare(b, a)
        );

        // O i * (log n)
        for(int i : nums) maxHeap.offer(i);
        int kth = Integer.MIN_VALUE;
        // O j * (log n)
        for(int j = 0; j < k && !maxHeap.isEmpty(); j++) {
            // O(log n)
            kth = maxHeap.poll();
        }

        return kth;
    }
}
