package org.algorithms.io.amazon2k24;

import java.util.Arrays;
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
        var count = 0;
        var left = new boolean[nums.length];
        var right = new boolean[nums.length];
        var maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for(int i = 0; i < nums.length; i++) {
            if(maxHeap.size() == k && maxHeap.peek() < nums[i]) {
                left[i] = true;
            }
            maxHeap.offer(nums[i]);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        maxHeap.clear();
        for(int i = nums.length - 1; i >=0 ; i--) {
            if(maxHeap.size() == k && maxHeap.peek() < nums[i]) {
                right[i] = true;
            }
            maxHeap.offer(nums[i]);

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        for(int i = 0; i < left.length; i++) {
            if(left[i] && right[i]) count++;
        }

        return count;
    }
}
