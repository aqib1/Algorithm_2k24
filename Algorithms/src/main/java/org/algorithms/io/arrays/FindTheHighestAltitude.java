package org.algorithms.io.arrays;

public class FindTheHighestAltitude {

    public static void main(String[] args) {
        System.out.println(
                largestAltitude(
                        new int[] {
                                44,32,-9,52,23,-50,50,33,-84,47,-14,84,36,-62,37,81,-36,-85,-39,67,-63,64,-47,95,91,-40,65,67,92,-28,97,100,81
                        }
                )
        );
    }

    // Time complexity O(n) space O(1)
    public static int largestAltitude(int[] gain) {
        int largestAltitude = 0;
        int altitude = 0;
        for(int i : gain) {
            altitude += i;
            largestAltitude = Math.max(largestAltitude, altitude);
        }

        return largestAltitude;
    }
}
