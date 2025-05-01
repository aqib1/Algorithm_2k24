package org.algorithms.io.wise.algorithm;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(
                numSubarrayProductLessThanK(
                        new int[] {10,5,2,6}, 100
                )
        );
    }

    // Time complexity O(n) and space O(1)
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)
            return 0;
        int product = 1;
        int count = 0;
        int start = 0;

        for(int end = 0; end < nums.length; end++) {
            product *= nums[end];

            while (product >= k) {
                product /= nums[start++];
            }

            count += (end - start) + 1;
        }

        return count;
    }
}
