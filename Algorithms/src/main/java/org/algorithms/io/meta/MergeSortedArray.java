package org.algorithms.io.meta;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        var n1 = new int[] {1,2,3,0,0,0};
        var n2 = new int[] {2, 5, 6};

        merge(n1, 3, n2, 3);
        System.out.println(
                Arrays.toString(n1)
        );

    }

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int[] res = new int[m + n];
        int i = 0, j = 0, k = 0;
        while(i < m && j < n) {
            if(num1[i] < num2[j]) {
                res[k++] = num1[i++];
            } else {
                res[k++] = num2[j++];
            }
        }

        while(i < m) {
            res[k++] = num1[i++];
        }

        while(j < n) {
            res[k++] = num2[j++];
        }

        System.arraycopy(res, 0, num1, 0, res.length);
    }
}
