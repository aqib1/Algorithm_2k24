package org.algorithms.io.stacks;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack<T> {

    private Object[] stack;
    private int top = -1;

    public Stack(int size) {
        stack = new Object[size];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == stack.length - 1;
    }

    public void push(T value) {
        if(isFull()) {
            throw new RuntimeException("Stack is full");
        }
        stack[++top] = value;
    }

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) stack[top--];
    }

    public T peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return (T) stack[top];
    }

    public T[] toArray() {
        return (T[]) Arrays.copyOf(stack, stack.length);
    }
}
