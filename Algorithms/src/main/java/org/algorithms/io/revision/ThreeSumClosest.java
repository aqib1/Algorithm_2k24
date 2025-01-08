package org.algorithms.io.revision;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(
                new int[] {4,0,5,-5,3,3,0,-4,-5},
                -2
        ));
    }
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = Integer.MAX_VALUE;
        int closetSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            // -5, -5, -4, 0, 0, 3, 3, 4, 5     (-2)
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(sum - target);
                if(diff == 0) return target;
                if(sum > target) {
                    end--;
                } else {
                    start++;
                }

                if(closet > diff) {
                    closet = diff;
                    closetSum = sum;
                }
            }
        }
        return closetSum;
    }
}
