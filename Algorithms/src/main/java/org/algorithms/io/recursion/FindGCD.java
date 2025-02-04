package org.algorithms.io.recursion;

public class FindGCD {
    public static void main(String[] args) {
        System.out.println(
                gcd(20, 10)
        );
    }

    // Euclidean Algorithm
    public static int gcd(int a, int b) {
        if(a == 0)
            return b;

        return gcd(b % a, a);
    }

    public static int euclidean(int a, int b) {
        if(a % b == 0)
            return b;

        return euclidean(b, a%b);
    }
}
