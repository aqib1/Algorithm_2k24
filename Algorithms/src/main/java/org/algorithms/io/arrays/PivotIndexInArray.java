package org.algorithms.io.arrays;

public class PivotIndexInArray {
    public static void main(String[] args) {
        System.out.println(
                pivotIndex(
                        new int[] {2, 1, -1}
                )
        );
    }
    
    // Time complexity O(3n) = O(n)
    // Space complexity O(2n) = O(n)
    public static int pivotIndex(int[] nums) {
        if(nums.length == 0) return -1;

        int len = nums.length;
        int []leftSum = new int[len];
        int []rightSum = new int[len];
        int sum = 0;

        for(int i = 0; i < len; i++) {
            sum += nums[i];
            leftSum[i] = sum;
        }

        sum = 0;
        for(int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            rightSum[i] = sum;
        }

        for(int i = 0; i < nums.length; i++) {
            if(leftSum[i] == rightSum[i])
                return i;
        }

        return -1;
    }
}
