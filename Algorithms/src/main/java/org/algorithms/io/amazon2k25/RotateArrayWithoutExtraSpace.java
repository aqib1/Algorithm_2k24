package org.algorithms.io.amazon2k25;

import java.util.Arrays;

public class RotateArrayWithoutExtraSpace {
    public static void main(String[] args) {
        var r = new RotateArrayWithoutExtraSpace();
        var arr = new int[] {1, 2, 3, 4, 5, 6, 7};
        r.rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    // Time complexity O(n) and space O(1)
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        //reverse first k numbers
        reverse(nums, 0, k - 1);
        // reverse all except first k
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while(i < j) {
            int tmp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = tmp;
        }
    }
}
