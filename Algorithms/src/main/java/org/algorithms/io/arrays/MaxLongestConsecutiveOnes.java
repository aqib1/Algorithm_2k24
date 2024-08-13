package org.algorithms.io.arrays;


public class MaxLongestConsecutiveOnes {
    public static void main(String[] args) {
        var maxLongest = new MaxLongestConsecutiveOnes();
        System.out.println(
                maxLongest.longestOnes(
                        new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1},
                        3
                )
        );
    }

    // Time complexity O(N)
    // Space complexity O(1)
    public int longestOnes(int[] nums, int k) {
        int maxLongestOnes = Integer.MIN_VALUE;
        int consecutiveZeroCount = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) {
                consecutiveZeroCount++;
            }

            while (consecutiveZeroCount > k) {
                if (nums[start] == 0) {
                    consecutiveZeroCount--;
                }
                start++;
            }

            maxLongestOnes = Math.max(maxLongestOnes, (end - start) + 1);
        }
        return maxLongestOnes;
    }


}
