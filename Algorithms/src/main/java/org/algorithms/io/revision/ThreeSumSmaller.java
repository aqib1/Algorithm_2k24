package org.algorithms.io.revision;

import java.util.Arrays;

public class ThreeSumSmaller {
    public static void main(String[] args) {
        System.out.println(
                threeSumSmaller(new int[] {0,-4,-1,1,-1,2}, -5)
        );
    }

    // -4, -1, -1, 0, 1, 2
    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            count += findMatchingCount(i, nums, target);
        }
        return count;
    }

    private static int findMatchingCount(int i, int[] nums, int target) {
        int start = i + 1;
        int end = nums.length - 1;
        int count = 0;
        while(start < end) {
            int sum = nums[i] + nums[start] + nums[end];

            if(sum < target) {
                count += end - start;
                start++;
            } else {
                end--;
            }
        }

        return count;
    }
}
