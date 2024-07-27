package org.algorithms.io.recursion;

public class FactorialTrailingZero {
    public static void main(String[] args) {
        var f = new FactorialTrailingZero();
        System.out.println(f.trailingZeroes(30));
    }
    // time = ON(LogN)
    // space O(1)
    public int trailingZeroes(int n) {
        int countZeros = 0;

        while(n != 0) {
            n /= 5;
            countZeros += n;
        }

        return countZeros;
    }
}
