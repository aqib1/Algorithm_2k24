package org.algorithms.io.interviewPrep2k25;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        var insertion = new InsertionSort();
        var data = new int[] {3, 1, -2, 8, -6, 2, 188};
        insertion.insertionSort(data);
        System.out.println(Arrays.toString(data));
    }
    public void insertionSort(int [] data) {
        for(int i = 1; i < data.length; i++) {
            int ptrData = data[i];
            int ptr = i;
            while(ptr > 0 && data[ptr - 1] >= ptrData) {
                data[ptr] = data[ptr - 1];
                ptr--;
            }

            data[ptr] = ptrData;
        }
    }
}
