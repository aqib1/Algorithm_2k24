package org.algorithms.io.queues;

import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStacks() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void push(int x) {
        while (!second.empty()) {
            first.push(second.pop());
        }
        first.push(x);

    }

    public int pop() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        return second.pop();
    }

    public int peek() {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }

        return second.peek();
    }

    public boolean empty() {
        return second.empty() && first.empty();
    }

    public static void main(String[] args) {
        var q = new QueueUsingStacks();
        q.push(1);
        q.push(5);
        q.push(11);

        while(!q.empty()) {
            System.out.println(q.pop());
        }
    }
}
