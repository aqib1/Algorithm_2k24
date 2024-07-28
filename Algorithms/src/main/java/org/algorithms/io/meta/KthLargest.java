package org.algorithms.io.meta;

import java.util.*;

public class KthLargest {

    public static void main(String[] args) {
        var k = new KthLargest(
                3, new int[]{4, 5, 8, 2}
        );


        System.out.println(k.add(3));
//        System.out.println(k.add(5));
//        System.out.println(k.add(10));
//        System.out.println(k.add(9));
//        System.out.println(k.add(4));
    }

    private final Queue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.k = k;
        for (int n : nums) {
            add(n);
        }
    }

    // 4 5 8 2
    // 3
    public int add(int val) {
        if(minHeap.size() < k || val > minHeap.peek()) {
            minHeap.offer(val);
            if(minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
