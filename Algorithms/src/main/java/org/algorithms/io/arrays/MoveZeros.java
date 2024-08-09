package org.algorithms.io.arrays;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        var moveZeros = new MoveZeros();
        int[] nums = new int[]{0, 1, 23, 0, 11, 0, 123};
        moveZeros.moveZeroes(nums);

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 1)
            return;

        int end = nums.length - 1;
        while (end >= 0) {
            for (int j = 0; j < end; j++) {
                if(nums[j] == 0) {
                    swap(nums, j, j + 1);
                }
            }
            end--;
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
