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

    // Time complexity O(N) and space is O(1)
    public static int removedDuplicatesUsingCount(int[] nums) {
        if(nums.length == 1)
            return 1;
        // start with index 1
        int i = 1;
        int count = 1;

        for(int j = 1; j < nums.length; j++) {
            if(nums[j - 1] == nums[j])
                count++;
            else count = 1;

            if(count <= 2) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }
}
