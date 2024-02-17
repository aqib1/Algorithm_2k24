package org.algorithms.io.google;

public class IsPalindromeNumber {
    public static void main(String[] args) {
        var is = new IsPalindromeNumber();
        System.out.println(is.isPalindrome(123));
    }
    public boolean isPalindrome(int x) {
        return x >= 0 && reverse(x) == x;
    }

    private int reverse(int x) {
        int reverse = 0;
        while(x != 0) {
            reverse = reverse * 10 + (x % 10);
            x /= 10;
        }

        return reverse;
    }
}
