package org.algorithms.io.educative;

public class ComputeKA {

    public static void main(String[] args) {
        var compute = new ComputeKA();
        System.out.println(
                compute.computeK(
                        new int[] {-3, 5, 6, 6, 7, 7},
                        0,
                        4
                )
        );
    }
    public int computeK(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] > arr[right]) {
                return computeK(arr, mid + 1, right);
            } else return computeK(arr, left, mid);
        } else
            return arr[left];
    }
}
