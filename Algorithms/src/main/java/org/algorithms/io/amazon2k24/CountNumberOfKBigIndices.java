package org.algorithms.io.amazon2k24;

import java.util.Comparator;
import java.util.PriorityQueue;

// Two heap problem
public class CountNumberOfKBigIndices {

    public static void main(String[] args) {
        var c = new CountNumberOfKBigIndices();
        System.out.println(
                c.kBigIndices(new int[]{2, 3, 6, 5, 2, 3}, 2)
        );
    }

    // Time OnLog(n)
    // Space O(2n) = O(n)
    public int kBigIndices(int[] nums, int k) {
        var maxHeap = new PriorityQueue<Integer>(
                Comparator.reverseOrder()
        );
        var leftValid = new boolean[nums.length];
        var rightValid = new boolean[nums.length];
        var count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (maxHeap.size() == k && maxHeap.peek() < nums[i]) {
                leftValid[i] = true;
            }
            maxHeap.offer(nums[i]);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        maxHeap.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (maxHeap.size() == k && maxHeap.peek() < nums[i]) {
                rightValid[i] = true;
            }
            maxHeap.offer(nums[i]);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(leftValid[i] && rightValid[i]) count++;
        }

        return count;
    }
}
