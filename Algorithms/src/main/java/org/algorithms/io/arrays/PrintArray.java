package org.algorithms.io.arrays;

public class PrintArray {
    public static void main(String[] args) {
        var arr =  new int[] {1, 2, 3, 4, 5};
        forLoop(arr, 0, arr.length);
    }

    // stack - for(arr, 0, 5)
    //          - for (arr, 1, 5)
    //              - for (arr, 2, 5)
    //                  - for (arr, 3, 5)
    //                      - for(arr, 4, 5)
    // Time complexity O(N) where N are numbers of arrays
    // Space complexity O(N) where N are numbers of arrays

    private static void forLoop(int[] arr, int start, int end) {
        if(start < end) {
            System.out.print(arr[start] + " ");
            forLoop(arr, start + 1, end);
        }
    }
}
