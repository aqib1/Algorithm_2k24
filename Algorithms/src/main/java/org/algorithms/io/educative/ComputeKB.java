package org.algorithms.io.educative;

public class ComputeKB {
    public static void main(String[] args) {
        System.out.println(
                computeB(new int[] {1, 2, 3, 55, 66, 76, 77},
                0,
                6,
                76)
        );
    }
    public static int computeB(int[] arr, int left, int right, int k) {
        if(left >= right)
            return -1;

        int mid = left + (right - left) / 2;
        if (arr[mid] < k) {
            return computeB(arr, mid + 1, right, k);
        } else if (arr[mid] > k) {
            return computeB(arr, left, mid, k);
        } else return arr[mid];
    }
}
