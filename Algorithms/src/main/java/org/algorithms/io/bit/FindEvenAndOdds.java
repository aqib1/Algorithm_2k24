package org.algorithms.io.bit;

public class FindEvenAndOdds {
    public static void main(String[] args) {
        System.out.println(isOdd(5));
    }

    // Time complexity O(1) and space O(1)
    public static boolean isEven(int number) {
        return (number ^ 1) == number + 1;
    }

    public static boolean isOdd(int number) {
        return (number ^ 1) == number - 1;
    }
}
