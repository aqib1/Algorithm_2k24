package org.algorithms.io.sorting;

public class QuickSearchKSmallestNumber {
    public static void main(String[] args) {
        var q = new QuickSearchKSmallestNumber();
        System.out.println(
                q.findKSmallestNumber(
                        new int[] {55, 11, 0, 2, 44, 9},
                        3
                )
        );
    }
    public int findKSmallestNumber(int []arr, int k) {
        return quickSearch(arr, 0, arr.length - 1, k);
    }

    // Time complexity OnLog(n)
    // Space complexity OLog(n)
    public int quickSearch(int []arr, int low, int high, int k) {
        int pivot = partition(arr, low, high);

        if(pivot == k - 1)
            return arr[pivot];

        if(pivot < k - 1)
            return quickSearch(arr, pivot + 1, high, k);
        else
            return quickSearch(arr, low, pivot - 1, k);
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

    private void swap(int[] arr, int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
}
