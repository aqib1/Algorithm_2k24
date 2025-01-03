package org.algorithms.io.math;

public class ReverseExponentiation {
    public static void main(String[] args) {
        var rev = new ReverseExponentiation();
        System.out.println(
                rev.reverseExponentiation(3)
        );
    }

    public int reverseExponentiation(int n) {
        return pow(n, reverse(n));
    }

    // Time complexity O(n)
    // Space complexity O(1)
    private int reverse(int n) {
        int reverse = 0;
        while(n != 0) {
            reverse = (reverse * 10) + n % 10;
            n /= 10;
        }
        return reverse;
    }


    // using peasant algorithm
    // Time complexity OLog(n)
    // Space complexity O(1)
    public int pow(int a, long pow) {
        if(pow == 0)
            return 1;
        else if(pow == 1)
            return a;
        else if(pow < 0)
            return 1 / pow(a, -pow);
        else if(pow % 2 == 0)
            return pow(a * a, pow / 2);
        else return a * pow(a * a, pow / 2);
    }
}
