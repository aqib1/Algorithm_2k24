package org.algorithms.io.arrays;

public class ContainerWithMostWater {
    // Input: height = [1,8,6,2,5,4,8,3,7]

    public static void main(String[] args) {
        var c = new ContainerWithMostWater();
        System.out.println(
                c.maxArea(
                        new int[]{
                                1, 8, 6, 2, 5, 4, 8, 3, 7
                        }
                )
        );
    }

  // Time complexity O(N)
  // Space complexity O(1)

    public int maxArea(int[] height) {

        int start = 0, end = height.length - 1;
        int maxArea = Integer.MIN_VALUE;

        while (start < end) {
            maxArea = Math.max(
                    maxArea,
                    Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxArea;
    }
}
