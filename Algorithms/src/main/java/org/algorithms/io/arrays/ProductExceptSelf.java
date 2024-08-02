package org.algorithms.io.arrays;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        var res = productExceptSelf(new int [] {-1,1,0,-3,3});
        System.out.println(Arrays.toString(res));
    }
    
    // Time complexity O(N)
    // Space complexity O(3*N) = O(3N) = O(N)
    public static int[] productExceptSelf(int[] nums) {
        int[][] solution = new int[3][nums.length];
        var leftProdRow = 0;
        var actualDataRow = 1;
        var rightProdRow = 2;
        for(int x = 0; x < nums.length; x++) {
            if(x == 0) {
                solution[leftProdRow][x] = 1;
            } else {
                solution[leftProdRow][x] = solution[leftProdRow][x-1] * solution[actualDataRow][x-1];
            }

            solution[actualDataRow][x] = nums[x];
        }

        for(int x = nums.length - 1; x >= 0; x--) {
            if(x == nums.length - 1) {
                solution[rightProdRow][x] = 1;
            } else {
                solution[rightProdRow][x] = solution[actualDataRow][x+1] * solution[rightProdRow][x+1];
            }

            nums[x] = solution[leftProdRow][x] * solution[rightProdRow][x];
        }

        return nums;
    }
}
