package org.algorithms.io.revision;

public class WaterTrappingProblem {

    public static void main(String[] args) {
        var w = new WaterTrappingProblem();
        System.out.println(w.trappingWater(
                new int[] {3, 0, 0, 2, 0, 4}
        ));
    }

    // O(2n) = 0(n)
    // O(n)
    public int trappingWater(int []arr) {
        int []leftToRightMax = new int[arr.length];
        int []rightToLeftMax = new int[arr.length];

        int countWater = 0;

        int maxTillNow = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            maxTillNow = Math.max(maxTillNow, arr[i]);
            leftToRightMax[i] = maxTillNow;
        }

        maxTillNow = Integer.MIN_VALUE;
        for(int i = arr.length - 1; i >= 0; i--) {
            maxTillNow = Math.max(maxTillNow, arr[i]);
            rightToLeftMax[i] = maxTillNow;
        }

        for(int i = 0; i < arr.length; i++) {
            countWater += Math.min(leftToRightMax[i], rightToLeftMax[i]) - arr[i];
        }

        return countWater;
    }
}
