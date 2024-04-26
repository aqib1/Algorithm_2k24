package org.algorithms.io.amazon2k25.twoPointers;

import java.util.Arrays;

public class RemoveDuplicatesSortedArrayI {

    public static void main(String[] args) {
        var d = new int[]{1,1,1,2,2,3};
        System.out.println(
                removeDuplicates(d)
        );

        System.out.println(Arrays.toString(d));
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
