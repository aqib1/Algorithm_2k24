package org.algorithms.io.amazon2k24;

import java.util.Arrays;

public class ThreeSumSmaller {
    // Time complexity O(n2) and space is O(1)
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int tripletsCount = 0;

        for(int i = 0; i < nums.length - 2; i++) {
            tripletsCount += findPairLessThan(i+1, nums, target - nums[i]);
        }

        return tripletsCount;
    }

    public int findPairLessThan(int start, int[] nums, int target) {
        int tripletsCount = 0;
        int end = nums.length - 1;
        while(start < end) {
            int sum = nums[start] + nums[end];
            if(sum < target) {
                tripletsCount += end - start;
                start++;
            } else {
                end--;
            }
        }

        return tripletsCount;
    }
}
