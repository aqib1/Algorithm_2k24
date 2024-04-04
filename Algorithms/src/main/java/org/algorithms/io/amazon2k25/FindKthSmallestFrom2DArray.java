package org.algorithms.io.amazon2k25;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestFrom2DArray {
    public static void main(String[] args) {
        var f = new FindKthSmallestFrom2DArray();
        System.out.println(
                f.kthSmallestUsingHeap(
                        new int[][] {
                                {1,5,9},
                                {10,11,13},
                                {12,13,15}
                        },
                        8
                )
        );
    }

    // Time complexity O(n.m Log(k)) and space O(k)
    public int kthSmallestUsingHeap(int[][] matrix, int k) {
        var maxHeap = new PriorityQueue<Integer>(k, Comparator.reverseOrder());

        for(int []m : matrix) {
            for(int i: m) {
                maxHeap.offer(i);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}
