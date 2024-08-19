package org.algorithms.io.arrays;

public class SubArrayWithLenKWithMaxSum {
    public static void main(String[] args) {
        int []data = new int[]{1, 4, 2, 10, 2, 3, 1, 0, 20};
        System.out.println(maxSum(
                data,
                data.length,
                4
        ));
    }

    // O(N) with space O(1)
    public static int maxSum(int[] arr, int n, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int start = 0, end = 0;
        while(end < n) {
            sum += arr[end];
            if((end - start) + 1 == k) {
                max = Math.max(max, sum);
                sum -= arr[start];
                start++;
            }

            end++;
        }

        return max;
    }
}
