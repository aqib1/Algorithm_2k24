package org.algorithms.io.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxKElements {
    public static void main(String[] args) {
        System.out.println(
                maxKElements(
                        new int [] {
                                881784984,829998714,730002802,56524562,120336848,548306998,801116106,828640251,519131180,819176153,476262254,15904939,540793851,53572296,259044378,491129827,561147559,205793082,967833729
                        },
                        16
                )
        );
    }

    // time complexity ON(logN)
    // space complexity O(N)
    public static long maxKElements(int[] nums, int k) {
        long maxElements = 0;
        var maxHeap = new PriorityQueue<Integer>(
                Comparator.reverseOrder()
        );

        for (int num : nums) maxHeap.offer(num);

        while (!maxHeap.isEmpty() && maxHeap.peek() != 0 && k != 0) {
            var max = maxHeap.poll();
            maxHeap.offer((int) Math.ceil(max / 3.0));
            maxElements += max;
            k--;
        }

        return maxElements;
    }
}
