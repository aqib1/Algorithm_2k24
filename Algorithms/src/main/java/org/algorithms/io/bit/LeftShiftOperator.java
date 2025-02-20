package org.algorithms.io.bit;

public class LeftShiftOperator {
    public static void main(String[] args) {

        printEvenDoublesTill(32);
    }

    private static void printEvenDoublesTill(int i) {
        int n = 2;
        while(n <= i) {
            System.out.println(n);
            n <<= 1; // double 2 -> 4
        }
    }
}
