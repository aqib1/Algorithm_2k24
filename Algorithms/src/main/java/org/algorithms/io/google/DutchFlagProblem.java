package org.algorithms.io.google;

import java.util.Arrays;

public class DutchFlagProblem {
    public static void main(String[] args) {
        var d = new DutchFlagProblem();
        var data = new int []{2,0,2,1,1,0};
        d.sortColors(data);
        System.out.println(Arrays.toString(data));
    }
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;
        while(mid <= end) {
            if(nums[mid] == 0) {
                swap(nums, start, mid);
                start++;
                mid++;
            } else if(nums[mid] == 2) {
                swap(nums, mid, end);
                end--;
            } else {
                mid++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
