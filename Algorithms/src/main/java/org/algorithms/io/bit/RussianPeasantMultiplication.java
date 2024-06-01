package org.algorithms.io.bit;

public class RussianPeasantMultiplication {
    public static void main(String[] args) {
        System.out.println(peasantMultiply(3, 5));
    }

    // Time complexity OLog(n) and space O(1)
    public static int peasantMultiply(int a, int b) {
        int result = 0;
        while(b > 0) {
            // check if b is odd then we need to add value of 'a' in result
            if((b ^ 1) == b - 1) { // odd value exclusive or with 1 always return value -1
                result += a;
            }
            // doubling a
            a <<= 1;
            // divide b by half
            b >>= 1;
        }

        return result;
    }
}
