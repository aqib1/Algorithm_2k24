package org.algorithms.io.sorting;

/*
* Consider the problem of adding two n-bit binary integers, stored in two
* element arrays A and B. The sum of the two integers should be stored in binary form in an
* (n+1) element array C. State the problem formally and write pseudocode for adding the two integers.
*
* */


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TwoBitBinaryIntegerSum {
    public static void main(String[] args) {
        var two = new TwoBitBinaryIntegerSum();
        System.out.println(
                two.sumBinary(
                        new int[] {1, 0, 1},
                        new int[] {1, 1, 1}
                )
        );
    }

    // Time complexity OnLog(n)
    // Space complexity O(n)
    public List<Integer> sumBinary(int[] arr1, int[] arr2) {
        var response = new ArrayList<Integer>(arr1.length + arr2.length);
        int carry = 0;
        int end1 = arr1.length - 1;
        int end2 = arr2.length - 1;

        while(end1 >= 0 && end2 >= 0) {
            int binarySum = binarySum(arr1[end1], arr2[end2], carry);
            response.add(binarySum % 10);
            carry = binarySum / 10;
            end1--;
            end2--;
        }

        while(end1 >= 0) {
            int binarySum = binarySum(arr1[end1--], 0, carry);
            response.add(binarySum % 10);
            carry = binarySum / 10;
        }

        while(end2 >= 0) {
            int binarySum = binarySum(0, arr2[end2--], carry);
            response.add(binarySum % 10);
            carry = binarySum / 10;
        }

        if(carry != 0) {
            response.add(carry);
        }

        response.sort(Comparator.reverseOrder());
        return response;
    }

    private int binarySum(int i, int i1, int carry) {
        if(i == 1 && i1 == 1)
            return 10 + carry;

        int sum = i + i1;
        if(sum == 0 && carry == 1) sum = 1;
        else if(sum == 1 && carry == 1) sum = 10;

        return sum;
    }
}
