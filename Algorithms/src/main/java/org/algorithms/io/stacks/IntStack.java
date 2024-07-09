package org.algorithms.io.stacks;

// Last in first out

import java.util.Random;

public class IntStack {
    private final int[] stack;
    private int top = -1;

    public IntStack(int size) {
        stack = new int[size];
    }

    // O(1)
    public void push(int value) {
        int index = ++top;
        if(index > stack.length) {
            throw new IllegalArgumentException("No more space");
        }
        stack[index] = value;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    // O(1)
    public int pop() {
        int index = top--;
        if(index < 0) {
            throw new IllegalArgumentException("No more elements");
        }
        return stack[index];
    }

    // O(1)
    public int peek() {
        return stack[top];
    }


    public static void main(String[] args) {
        var stack = new IntStack(5);
        var random = new Random();
        while(!stack.isFull()) {
            stack.push(random.nextInt(100));
        }

        System.out.println("First number : " + stack.peek());

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }
}
