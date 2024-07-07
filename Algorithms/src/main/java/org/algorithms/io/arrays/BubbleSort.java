package org.algorithms.io.arrays;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        bubbleSort(new int[]{
                                4, 5, 1, 2, 33, 12, 0
                        }))
        );
    }

    // Time complexity is O(N * 2)
    // Space complexity is O(1)
    private static int[] bubbleSort(int[] data) {
        int limit = data.length - 1;
        while(limit >= 0) {
            for (int i = 0; i < limit; i++) {
                if (data[i] > data[i + 1]) {
                    swap(data, i, i + 1);
                }
            }
            limit--;
        }
        return data;
    }

    private static void swap(int[] data, int i, int i1) {
        int val = data[i];
        data[i] = data[i1];
        data[i1] = val;
    }
}
