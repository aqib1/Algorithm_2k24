package org.algorithms.io.meta;

import java.util.Arrays;

public class MergeSortedArrayWithConstantSize {

    public static void main(String[] args) {
        var n1 = new int[] {0};
        var n2 = new int[] {1};
        merge(n1, 0, n2, 1);
        System.out.println(Arrays.toString(n1));
    }

    public static void merge(int[] num1, int m, int[] num2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while(p >= 0) {
            if(p2 < 0)
                break;
            if(p1 >=0 && num1[p1] > num2[p2]) {
                num1[p] = num1[p1--];
            } else {
                num1[p] = num2[p2--];
            }
            p--;
        }
    }
}
