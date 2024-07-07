package org.algorithms.io.arrays;

// Last in first out

public class Stack {
    private final int[] stack;
    private int top = -1;

    public Stack(int size) {
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
        var stack = new Stack(5);
        stack.push(2);
        stack.push(1);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
