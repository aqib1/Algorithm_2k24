package org.algorithms.io.amazon2k24;

import java.util.Arrays;

public class TwoSumLessThanK {
    public static void main(String[] args) {
        System.out.println(twoSumLessThanK(
                new int[] {1,2,4,5},
                6
        ));
    }

    // OnLog(n) with space O(1)
    public static int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while(nums[end] >= k) end--;
        int maxLessThanK = -1;
        while(start < end) {
            int sum = nums[start] + nums[end];

            if(sum >= k) {
                end--;
            } else {
                if(sum > maxLessThanK) {
                    maxLessThanK = sum;
                }
                start++;
            }
        }

        return maxLessThanK;
    }
}
