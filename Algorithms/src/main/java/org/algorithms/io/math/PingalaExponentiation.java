package org.algorithms.io.math;

public class PingalaExponentiation {

    // time complexity OLog(n)
    // space complexity O(1)
    public double pow(int a, long pow) {
        if(pow == 0)
            return 1;
        else if(pow == 1.0)
            return a;
        else if(pow < 0)
            return 1 / pow(a, -pow);
        else {
            double x = pow(a, pow / 2);
            if(pow % 2 == 0)
                return x * x;
            else return x * x * a;
        }
    }
}
