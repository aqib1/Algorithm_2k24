package org.algorithms.io.google;

public class WaterTrappingProblem {
    // Time complexity O(n) and space O(n)
    public static void main(String[] args) {
        var w = new WaterTrappingProblem();
        System.out.println(
                w.trap(
                        new int[] {0,1,0,2,1,0,1,3,2,1,2,1}
                )
        );
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        var maxFromLeft = new int[height.length];
        var maxFromRight = new int[height.length];
        var water = 0;

        maxFromLeft[0] = height[0];
        for(int left = 1; left < height.length; left++) {
            maxFromLeft[left] = Math.max(maxFromLeft[left -1], height[left]);
        }

        maxFromRight[height.length - 1] = height[height.length - 1];
        for(int right = height.length - 2; right >= 0; right--) {
            maxFromRight[right] = Math.max(maxFromRight[right + 1], height[right]);
        }

        for(int i = 0; i < height.length; i++) {
            water += Math.min(maxFromLeft[i], maxFromRight[i]) - height[i];
        }

        return water;
    }
}
