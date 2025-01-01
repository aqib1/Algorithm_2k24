package org.algorithms.io.sorting;

public class QuickSearchKLargestNumber {

    public static void main(String[] args) {
        var quickSearch = new QuickSearchKLargestNumber();
        System.out.println(
                quickSearch.findKBiggest(
                        new int[] {5, 1, 2, 13, 4, 10},
                        2
                )
        );
    }

    public int findKBiggest(int [] arr, int k) {
        return findKBiggest(arr, 0, arr.length - 1, arr.length - k);
    }

    public int findKBiggest(
            int [] arr,
            int low,
            int high,
            int k
    ) {
        int pivot = partition(arr, low, high);

        if(pivot == k)
            return arr[pivot];

        if(pivot < k) {
           return findKBiggest(arr, pivot + 1, high, k);
        } else
          return findKBiggest(arr, low, pivot - 1, k);
    }

    private int partition(int[] arr, int low, int high) {
        int pivotValue = arr[high];
        int i = low - 1;

        for(int j = low; j <= high; j++) {
            if(arr[j] < pivotValue) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
