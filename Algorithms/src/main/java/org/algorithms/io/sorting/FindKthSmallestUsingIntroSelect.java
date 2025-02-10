package org.algorithms.io.sorting;

public class FindKthSmallestUsingIntroSelect {
    // Public method: k is 1-indexed.
    public static int kthLargestUsingIntroSelect(int[] arr, int k) {
        if (k < 1 || k > arr.length)
            throw new IllegalArgumentException("k is out of bounds");
        // Convert to 0-indexed and call the recursive method.
        return kthLargestUsingIntroSelect(arr, 0, arr.length - 1, arr.length - k);
    }

    // Recursive method to find the kth smallest element within arr[left...right].
    private static int kthLargestUsingIntroSelect(int[] arr, int left, int right, int k) {
        if (left == right) {
            return arr[left];
        }

        // Choose a pivot index using the Median of Medians approach.
        int pivotValue = medianOfMedians(arr, left, right);
        int pivotIndex = partition(arr, left, right, pivotValue);

        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            return kthLargestUsingIntroSelect(arr, left, pivotIndex - 1, k);
        } else {
            return kthLargestUsingIntroSelect(arr, pivotIndex + 1, right, k);
        }
    }

    // Partition the array around the pivot value.
    private static int partition(int[] arr, int left, int right, int pivotValue) {
        int pivotIndex = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == pivotValue) {
                pivotIndex = i;
            }
        }
        swap(arr, pivotIndex, right); // Move pivot to end

        int storeIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i);
                storeIndex++;
            }
        }
        swap(arr, storeIndex, right); // Move pivot to final place
        return storeIndex;
    }

    // Swap method to exchange two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Insertion Sort for small subarrays
    public static void insertionSort(int[] arr, int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= start && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Select a good pivot index using the Median of Medians technique.
    private static int medianOfMedians(int[] arr, int start, int end) {
        int n = end - start + 1;
        if (n <= 5) {
            insertionSort(arr, start, end);
            return arr[start + n / 2]; // Return index of median
        }

        int numMedians = (n + 4) / 5;
        int[] medians = new int[numMedians];
        for (int i = 0; i < numMedians; i++) {
            int subLeft = start + i * 5;
            int subRight = Math.min(subLeft + 4, end);

            insertionSort(arr, subLeft, subRight);

            medians[i] = arr[subLeft + (subRight - subLeft) / 2];
        }

        // Find the median of the medians correctly using kthSmallest
        return medianOfMedians(medians, 0, numMedians - 1);
    }

    // Example main method for testing.
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19, 4};
        int k = 3; // Looking for the 3rd smallest element.
        System.out.println("The " + k + "th smallest element is: " + kthLargestUsingIntroSelect(arr, k));
    }
}