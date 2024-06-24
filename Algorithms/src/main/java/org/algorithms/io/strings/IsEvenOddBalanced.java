package org.algorithms.io.strings;

public class IsEvenOddBalanced {
    public static void main(String[] args) {
        System.out.println('2' - '0');
    }

    // Time complexity O(n) where n is number of characters
    // Space complexity O(1)
    public boolean isBalanced(String num) {
        int evenSum = 0, oddSum = 0;

        for(int i = 0; i < num.length(); i++) {
            int n = num.charAt(i) - '0';
            if(i % 2 == 0) {
                evenSum += n;
            } else {
                oddSum += n;
            }
        }

        return evenSum == oddSum;
    }
}
