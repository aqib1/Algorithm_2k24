package org.algorithms.io.arrays;

public class LongestSubarrayAfterDeletingOneElement {

    public static void main(String[] args) {
        System.out.println(
                longestSubArrayByRemovingOne(
                        new int[]{
                                1, 1, 0, 1
                        }
                )
        );
    }

    // Time complexity O(n*m) and space O(1)
    public static int longestSubArrayByRemovingOne(int[] nums) {
        int start = 0, end = 0;
        int longestSubArray = Integer.MIN_VALUE;
        int zeroCount = 0;

        while(end < nums.length) {
            if(nums[end] == 0) {
                zeroCount++;
            }

            while(zeroCount > 1) {
                if(nums[start] == 0) {
                    zeroCount--;
                }
                start++;
            }

            longestSubArray = Math.max(longestSubArray, end - start);
            end++;
        }

        return longestSubArray;
    }

    // Time complexity O(n) and space complexity O(1)
    public static int longestSubarray(int[] nums) {
        int start = 0, current = 0;
        int longest = Integer.MIN_VALUE;
        int jumpIndex = -1;
        int countOnes = 0;

        while (current < nums.length) {
            if (nums[current] == 1) countOnes++;
            if (nums[current] == 0 && jumpIndex == -1) {
                jumpIndex = current;
            }

            longest = Math.max(longest, (current - start));

            if (current + 1 < nums.length
                    && jumpIndex != -1 && nums[current + 1] == 0) {
                start = jumpIndex + 1;
                jumpIndex = -1;
            }


            current++;
        }

        return countOnes == 0 ?
                0 : countOnes == nums.length ?
                countOnes - 1 : longest;
    }
}
