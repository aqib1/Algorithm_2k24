package org.algorithms.io.interviewPrep2k25.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        var b = new BubbleSort();
        var data = new int[] {3, 4, 1, 2, -9};
        b.sort(data);
        System.out.println(Arrays.toString(data));
    }

    // Time complexity O(n)2 and space O(1)
    public void sort(int[] data) {
        int limit = data.length - 1;
        while (limit >= 0) {
            for(int i = 0; i < limit; i++) {
                if(data[i] > data[i + 1])
                    swap(data, i, i + 1);
            }
            limit--;
        }
    }

    public void swap(int[] data, int i, int j) {
        var tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }
}
