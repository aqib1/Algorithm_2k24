package org.algorithms.io.arrays;


public class IncreasingTriplet {
    public static void main(String[] args) {
        var increasingTriplet = new IncreasingTriplet();
        System.out.println(increasingTriplet.increasingTripletBruteForce(
                new int[]{
                        5, 4, 3, 2, 1
                }
        ));
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }

        return false;
    }

    // Time complexity O(n) + O(n) + O(n) = O3(n) = O(n)
    // Space complexity O(n) + O(n) = O2(n) = O(n)
    public boolean increasingTripletBruteForce(int[] nums) {
        int[] maxFromRight = new int[nums.length];
        int[] minFromLeft = new int[nums.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (max < nums[i]) {
                max = nums[i];
            }
            maxFromRight[i] = max;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
            minFromLeft[i] = min;
        }

        for (int i = 0; i < nums.length; i++) {
            if (minFromLeft[i] < nums[i] &&
                    nums[i] < maxFromRight[i])
                return true;
        }

        return false;
    }
}
