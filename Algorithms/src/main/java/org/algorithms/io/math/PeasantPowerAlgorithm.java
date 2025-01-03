package org.algorithms.io.math;

public class PeasantPowerAlgorithm {
    public static void main(String[] args) {
        var peasant = new PeasantPowerAlgorithm();
        System.out.println(
                peasant.myPow(8, 2)
        );
    }

    // Time complexity OLog(n)
    // Space complexity O(1)
    public double myPow(double a, long pow) {
        if(pow == 0)
            return 1;
        else if(pow == 1)
            return a;
        else if(pow < 0)
            return 1 / myPow(a, -pow);
        // even power and peasant method define
        else if(pow % 2 == 0)
            return myPow(a * a, pow / 2);
        // odd power
        else return a * myPow(a * a, pow / 2);
    }
}
