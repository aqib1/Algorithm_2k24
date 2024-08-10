package org.algorithms.io.arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        var moveZeros = new MoveZeros();
        int[] nums = new int[]{1, 1, 23, 0, 11, 0, 123};
        moveZeros.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    // Time complexity O(N)
    // Space complexity O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1)
            return;

        int cursor = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[cursor++] = nums[i];
            }
        }

        while(cursor < nums.length) {
            nums[cursor++] = 0;
        }
    }
}
