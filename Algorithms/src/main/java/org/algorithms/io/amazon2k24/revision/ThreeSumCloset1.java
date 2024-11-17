package org.algorithms.io.amazon2k24.revision;

import java.util.Arrays;

public class ThreeSumCloset1 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }

    // -4, -1, 1, 2
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int closetSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                if(sum == target)
                    return target;

                if(sum < target) {
                    start++;
                } else {
                    end--;
                }

                if(diff < closet) {
                    closet = diff;
                    closetSum = sum;
                }

            }
        }

        return closetSum;
    }
}
