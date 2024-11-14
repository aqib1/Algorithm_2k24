package org.algorithms.io.amazon2k24;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }

//    Example 1:
//
//    Input: nums = [-4, -1, 1, 2], target = 1
//    Output: 2
//    Explanation:
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int targetSum = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int absDiff = Math.abs(target - sum);

                if(sum == target)
                    return target;

                if(absDiff < min) {
                    min = absDiff;
                    targetSum = sum;
                }

                if(sum < target) {
                    start++;
                } else {
                    end--;
                }


            }
        }
        return targetSum;
    }
}
