package org.algorithms.io.stacks;

import java.util.Arrays;
import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        monotonicIncreasing(
                                new int[]{3, 1, 4, 1, 5, 9, 2, 6}
                        ))
        );
    }

    // Time complexity O(n)
    // Space complexity O(n)
    public static int[] monotonicIncreasing(int[] arr) {
        var monotonicStack = new Stack<Integer>();
        for (int a : arr) {

            while (!monotonicStack.isEmpty() && monotonicStack.peek() > a) {
                monotonicStack.pop();
            }

            monotonicStack.push(a);
        }

        return monotonicStack.stream().mapToInt(Integer::intValue).toArray();
    }
}
