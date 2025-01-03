package org.algorithms.io.math;

public class MyPowerBinaryExponentiation {
    public static void main(String[] args) {
        var m = new MyPowerBinaryExponentiation();
        System.out.println(
                m.myPow(3, 2)
        );
    }

    // Time complexity OLog(n)
    // Space complexity O(1)
    public double myPow(double x, long n) {
        if(n == 0)
            return 1;
        else if(n < 1)
            return 1 / myPow(x, -n);
        else if(n % 2 == 0)
            return myPow(x * x, n / 2);
        else return x * myPow(x * x, (n - 1) / 2);
    }
}
