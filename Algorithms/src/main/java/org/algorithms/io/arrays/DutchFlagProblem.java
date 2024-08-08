package org.algorithms.io.arrays;

public class DutchFlagProblem {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 1) {
            return;
        }

        int start = 0, mid = 0, end = nums.length - 1;
        while(mid <= end) {
            if(nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if(nums[mid] == 2){
                swap(nums, mid, end);
                end--;
            } else {
                mid++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

