package org.algorithms.io.stacks;

import java.util.Arrays;

public class CustomStack {
    // Time complexity O(n)
    // Space complexity O(n)
    public static void main(String[] args) {
        var custom = new CustomStack(3);
        custom.push(1);
        custom.push(2);
        System.out.println(custom.pop());
        custom.push(2);
        custom.push(3);
        custom.push(4);
        custom.increment(5, 100);
        custom.increment(2, 100);
        System.out.println(custom.pop());
        System.out.println(custom.pop());
        System.out.println(custom.pop());
        System.out.println(custom.pop());
        System.out.println(Arrays.toString(custom.stack));
    }

    private int []stack;
    private int top = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if(top < stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if(top >= 0) {
            return stack[top--];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for(int i = 0; i < Math.min(k, top + 1); i++) {
            stack[i] += val;
        }
    }
}
