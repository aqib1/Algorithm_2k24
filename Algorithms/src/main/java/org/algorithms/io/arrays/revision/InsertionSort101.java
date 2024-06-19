package org.algorithms.io.arrays.revision;

import java.util.Arrays;

public class InsertionSort101 {

    public static void main(String[] args) {
        var i = new InsertionSort101();
        int[] data = new int[] { 10, 10 , 5, 1, 9, 8 };
        i.insertionSort(data);

        System.out.println(
                Arrays.toString(data)
        );
    }

    // Time complexity O(n)2
    public void insertionSort(int []arr) {
        for(int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
