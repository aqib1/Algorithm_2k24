package org.algorithms.io.bit;

import java.util.Arrays;

public class CountOnesOfBinary {
    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(countBits(2))
        );
    }

    // using brian kernighan's algorithm
    // Time complexity O(n * k) where k is number of 1 bits in a binary
    // space is O(n + 1)
    public static int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            int value = i;
            while (value != 0) {
                value &= value - 1;
                count++;
            }
            result[i] = count;
        }

        return result;
    }
}
