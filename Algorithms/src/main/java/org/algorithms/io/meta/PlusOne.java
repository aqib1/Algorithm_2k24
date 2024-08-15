package org.algorithms.io.meta;

import java.util.Arrays;
import java.util.Stack;

public class PlusOne {
    public static void main(String[] args) {
        var p = new PlusOne();
        System.out.println(
                Arrays.toString(p.plusOne(new int[] {9, 9, 9, 9}))
        );
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public int[] plusOne(int[] digits) {
        if(digits.length < 1)
            return digits;

        var queue = new Stack<Integer>();
        int carry = 1;
        for(int i = digits.length - 1; i >=0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            queue.push(sum % 10);
        }
        if(carry != 0) queue.push(carry);

        int size = queue.size();
        int []response = new int[size];
        for(int i = 0; i < size; i++) {
            response[i] = queue.pop();
        }

        return response;
    }
}
