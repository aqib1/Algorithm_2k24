package org.algorithms.io.arrays;

public class MinSwaps {
    // Time complexity O(n)
    // Space complexity O(1)
    public int minSwaps(int[] data) {
        int windowSize = 0;
        for(int i : data) windowSize += i;

        if(windowSize == 0) return -1;

        int currOnesInWindow = 0;
        int maxOnesInWindows = Integer.MIN_VALUE;

        for(int i = 0; i < data.length; i++) {
            currOnesInWindow += data[i];
            if(i >= windowSize) {
                currOnesInWindow -= data[i - windowSize];
            }
            maxOnesInWindows = Math.max(maxOnesInWindows, currOnesInWindow);
        }

        return windowSize - maxOnesInWindows;
    }
}
