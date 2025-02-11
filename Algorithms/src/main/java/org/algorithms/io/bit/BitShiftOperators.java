package org.algorithms.io.bit;

public class BitShiftOperators {
    public static void main(String[] args) {
        printEvenDoublesTill(32);
        printEventHalfTill(32, 2);
    }

    private static void printEvenDoublesTill(int i) {
        int n = 2;
        while(n <= i) {
            System.out.println(n);
            n <<= 1; // double 2 -> 4 (Left bit shift operator move bits to left side and add 0 at the end
        }
    }

    private static void printEventHalfTill(int from, int till) {
        while(from >= till) {
            System.out.println(from);
            from >>= 1; // move every bit to right (in right shift operator most right bit is lost and we will add 0
            // at the beginning.
        }
    }
}
