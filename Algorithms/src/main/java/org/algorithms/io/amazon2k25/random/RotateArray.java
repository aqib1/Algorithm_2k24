package org.algorithms.io.amazon2k25.random;


import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        var arr = new int[] {-1, -100, 3, 99};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }

    // Time complexity O(n) and space complexity O(n*2) = O(2n) = O(n)
    public static void rotate(int[] nums, int k) {
        if(k < 0)
            throw new IllegalArgumentException();

        k = k % nums.length;

        int []rotate = new int[nums.length * 2];
        System.arraycopy(nums, 0, rotate, 0, nums.length);
        System.arraycopy(nums, 0, rotate, nums.length, nums.length);

        System.arraycopy(rotate, nums.length - k, nums, 0, nums.length);

    }
}
