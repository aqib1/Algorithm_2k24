package org.algorithms.io.sorting;

public class MedianOfMedians {
    public int medianOfMedians(int [] arr, int start, int end) {
        int n = end - start + 1;
        if(n <= 5) {
            insertionSort(arr, start, end);
            return arr[start + n / 2];
        }
        int []medians = new int[(n + 4) / 5];
        for(int i = 0; i < medians.length; i++) {
            int subLeft = start + i * 5;
            int subRight = Math.min(subLeft + 4, end);
            insertionSort(arr, subLeft, subRight);

            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }
        return medianOfMedians(medians, 0, medians.length - 1);
    }

    private void insertionSort(int[] arr, int start, int end) {
       for(int ptr = start + 1; ptr <= end; ptr++) {
           int data = arr[ptr];
           int j = ptr;
           while(j > 0 && arr[j - 1] >= data) {
                arr[j] = arr[j - 1];
               j--;
           }
           arr[j] = data;
       }
    }
}
