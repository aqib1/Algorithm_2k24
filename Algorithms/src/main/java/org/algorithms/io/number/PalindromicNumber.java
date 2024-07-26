package org.algorithms.io.number;

public class PalindromicNumber {

    public static void main(String[] args) {
        var p = new PalindromicNumber();

        System.out.println(p.isPalindromeOptimal(-121));
    }

    // Time complexity OLog(N)
    // Space complexity O(1)
    public boolean isPalindromeOptimal(int x) {
        return x >= 0 && reverse(x) == x;
    }

    public int reverse(int x) {
        int reverse = 0;

        while(x != 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse;
    }

    // Time complexity O(N)
    // Space complexity O(N)
    public boolean isPalindrome(int x) {
        var val = String.valueOf(x);
        var builder = new StringBuilder(val);
        return val.contentEquals(builder.reverse());
    }
}
