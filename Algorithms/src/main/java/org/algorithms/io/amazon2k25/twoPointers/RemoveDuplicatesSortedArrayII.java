package org.algorithms.io.amazon2k25.twoPointers;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrayII {
    public static void main(String[] args) {
        var d = new int[]{1,1,1,2,2,3};
        System.out.println(
                removeDuplicatesUsingSlowFastPointer(d)
        );

        System.out.println(Arrays.toString(d));
    }

    public static int removeDuplicatesUsingSlowFastPointer(int[] nums) {
        if(nums.length <= 2)
            return nums.length;

        int slow = 2, fast = 2;

        while(fast < nums.length) {
            if(nums[slow - 2] == nums[fast]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }


        return slow;
    }
}
