package org.algorithms.io.arrays;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] data) {
        // pointer
        for(var ptr = 1; ptr < data.length; ptr++) {
            var ptrData = data[ptr];
            var j = ptr;
            while(j > 0 && data[j - 1] >= ptrData) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = ptrData;
        }

    }

    public static void main(String[] args) {
        var data = new int[]{-100, 3, 2, 12, 9, 1, 0, 55, -1, -2, 125, -9};
        var insertionSort = new InsertionSort();

        insertionSort.insertionSort(data);

        System.out.println(Arrays.toString(data));
    }
}
