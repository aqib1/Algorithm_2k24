package org.algorithms.io.amazon2k24;

public class WaterTrapped {
    // Time complexity O(n) and space is O(1)
    public int maxArea(int[] height) {
        var limit = height.length;
        int first = 0, last = limit - 1;
        var maxArea = Integer.MIN_VALUE;

        while(first < last) {
            maxArea = Math.max(
                    maxArea,
                    Math.min(height[first], height[last]) * (last - first)
            );

            if(height[first] < height[last]) {
                first++;
            } else  {
                last--;
            }
        }

        return maxArea;
    }
}
