package org.algorithms.io.heap;

import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        var f = new FindKthLargest();
        System.out.println(
                f.findKthLargest(
                        new int[] {11, 12, 13, 14, 2},
                        3
                )
        );
    }

    // Time complexity OnLog(k)
    // Space complexity O(k)
    public int findKthLargest(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>(k);
        for(int num: nums) {
            if(minHeap.size() == k && num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            } else if(minHeap.size() != k) {
                minHeap.offer(num);
            }
        }
        return minHeap.isEmpty() ? -1: minHeap.poll();
    }
}
