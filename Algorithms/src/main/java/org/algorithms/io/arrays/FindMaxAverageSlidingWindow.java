package org.algorithms.io.arrays;

public class FindMaxAverageSlidingWindow {

    public static void main(String[] args) {
        var findMaxAvg = new FindMaxAverageSlidingWindow();
        System.out.println(
                findMaxAvg.findMaxAverage(
                        new int[]{-1},
                        1
                )
        );
    }

    /*
     * Time complexity O(N)
     * Space complexity O(1)
     * */
    public double findMaxAverage(int[] nums, int k) {
        if (k > nums.length) return -1;
        int start = 0, end = 0;
        double max = Integer.MIN_VALUE;
        int sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            if ((end - start) + 1 == k) {
                max = Math.max(max, (double) sum / k);
                sum -= nums[start];
                start++;
            }
            end++;
        }

        return max;
    }
}
