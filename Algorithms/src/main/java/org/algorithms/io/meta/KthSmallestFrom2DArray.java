package org.algorithms.io.meta;

public class KthSmallestFrom2DArray {

    /**
     * Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     * You must find a solution with a memory complexity better than O(n2).
     * Example 1:
     * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
     * Output: 13
     * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
     * Example 2:
     * Input: matrix = [[-5]], k = 1
     * Output: -5
     * Constraints:
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 300
     * -109 <= matrix[i][j] <= 109
     * All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
     * 1 <= k <= n2
     * */

    // We will use range based binary search
    // Time complexity O(NLog(max - min)) and space O(1)
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0]; // smallest number
        int high = matrix[matrix.length - 1][matrix.length - 1]; // largest number

        // let's use all number in between (max - min)
        while(low < high) {
            int mid = low + (high - low) / 2;
            int countLessThanOrEqual = countLessThanOrEqual(mid, matrix);
            if(countLessThanOrEqual < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private int countLessThanOrEqual(int mid, int[][] matrix) {
        int count = 0;
        int column = matrix.length - 1;
        int row = 0;

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
