package org.algorithms.io.amazon2k25.random;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthSmallestFrom2DArray {
    public static void main(String[] args) {
        var f = new FindKthSmallestFrom2DArray();
        System.out.println(
                f.kthSmallestUsingBinarySearch(
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


    // Total O(N * Log(max - min)) and space is O(1)
    public int kthSmallestUsingBinarySearch(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];
        // this is OLog(max - min)
        while (low < high) {
            int mid = low + (high - low) / 2;
            int countLessOrEqual = countLessOrEqual(matrix, mid);
            if(countLessOrEqual < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // this is O(N)
    public int countLessOrEqual(int[][] matrix, int mid) {
        int column = matrix.length - 1;
        int row = 0;
        int count = 0;

        while(column >= 0 && row < matrix.length) {
            if(matrix[row][column] <= mid) {
                count += (column + 1);
                row++;
            } else {
                column--;
            }
        }

        return count;
    }
}
