package org.algorithms.io.arrays;

public class SelectionSort {

    // Time complexity O(n2)
    // Space complexity O(1)
    private void selectionSort(int[] data) {
        int start = 0;
        while(start < data.length) {
            int smallest = Integer.MIN_VALUE;
            int smallestValueIndex = start;
            for (int i = start; i < data.length; i++) {
                if (data[i] >= smallest) {
                    smallest = data[i];
                    smallestValueIndex = i;
                }
            }
            replace(data, start, smallestValueIndex);
            start++;
        }
    }

    private void replace(int[] heights, int start, int smallestValueIndex) {
        var first = heights[start];
        heights[start] = heights[smallestValueIndex];
        heights[smallestValueIndex] = first;
    }
}
