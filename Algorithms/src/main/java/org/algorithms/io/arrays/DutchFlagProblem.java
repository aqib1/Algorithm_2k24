package org.algorithms.io.arrays;

import java.util.Arrays;

public class DutchFlagProblem {
    public static void main(String[] args) {
        var dutch = new DutchFlagProblem();
        int[] numbers = new int[]{2, 2, 1, 0, 2, 1, 0, 0, 1};
        dutch.sortColors(
                numbers
        );
        System.out.println(
                Arrays.toString(numbers)
        );
    }

    // Space complexity O(1)
    // Time complexity O(N) where N is number of elements
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;
        while (mid <= end) {
            if (nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, end);
                end--;
            } else {
                mid++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
