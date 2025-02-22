package org.algorithms.io.number;

public class ReversedInteger {
    public static void main(String[] args) {
        System.out.println(
                reverse(3331)
        );
    }

    // Time complexity O(n) and space O(1)
    public static int reverse(int n) {
        int reversed = 0;
        while(n != 0) {
          reversed = reversed * 10 + (n % 10);
          n /= 10;
        }
        return reversed;
    }
}
