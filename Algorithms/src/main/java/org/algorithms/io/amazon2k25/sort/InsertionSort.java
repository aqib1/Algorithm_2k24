package org.algorithms.io.amazon2k25.sort;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        var insertion = new InsertionSort();
        var data = new int[] {4, -1, 0, 22, 76, 3, 12};
        insertion.sort(data);
        System.out.println(Arrays.toString(data));
    }

    // Time complexity O(n2) and space O(1)
    public void sort(int[] data) {
        for(int i = 1; i < data.length; i++) {
            int keyData = data[i];
            int j = i;
            while(j > 0 && data[j - 1] >= keyData) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = keyData;
        }
    }
}
