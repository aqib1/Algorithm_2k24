package org.algorithms.io.amazon2k25.twoPointers;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrayI {

    public static void main(String[] args) {

        var d = new int[]{1,1,1,2,2,3};
        System.out.println(
                removeDuplicatesUsingCount(d)
        );

        System.out.println(Arrays.toString(d));
    }

    // Time complexity O(N) and space complexity O(1)
    public static int removeDuplicatesUsingCount(int [] nums) {
        int i = 1;
        int count = 1;

        for(int j = 1; j < nums.length; j++) {
            if(nums[j] == nums[j - 1]) {
                count++;
            } else {
                count = 1;
            }

            if(count == 1) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }

    // Time complexity O(N) and space complexity O(1)
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1)
            return 1;
        int slow = 1, fast = 1;

        while (fast < nums.length) {
            if(nums[slow - 1] == nums[fast]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }

        return slow;
    }
}
