package org.algorithms.io.bit;

public class CountBits {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(120));
        System.out.println(countBits(120));
    }

    public static int countBits(int number) {
        int count = 0;

        while(number > 0) {
            count++;

            number >>= 1;
        }

        return count;
    }
}
