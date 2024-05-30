package org.algorithms.io.bit;

public class RussianPeasantMultiplication {
    public static void main(String[] args) {
        System.out.println(peasantMultiplyRecur(4, 2));
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

    public static int peasantMultiplyRecur(int a, int b) {
        if(b == 0)
            return 0;
        else {
            int result = peasantMultiplyRecur(a << 1, b >> 1);
            if((b ^ 1) == b - 1)
                result += a;

            return result;
        }
    }

    public static int peasantMultiplyRecur(int a, int b, int result) {
        if(b == 0) return result;

        if((b ^ 1) == b - 1) result += a;

        return peasantMultiplyRecur(a << 1, b >> 1, result);
    }
}
