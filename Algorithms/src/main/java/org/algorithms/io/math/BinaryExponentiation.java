package org.algorithms.io.math;

public class BinaryExponentiation {
    // Time complexity OLog(n)
    // Space complexity O(1)
    public double myPow(double x, long n) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 1.0 / myPow(x, -n);
        if (n % 2 == 1)
            return x * myPow(x * x, (n - 1) / 2);
        else return myPow(x * x, n / 2);
    }
}
