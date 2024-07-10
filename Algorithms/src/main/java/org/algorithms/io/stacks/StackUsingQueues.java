package org.algorithms.io.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }


    // O(n)
    public void push(int x) {
        // add first in q2
        // O(1)
        q2.add(x);

        // O(n) where n is the number of elements in q1
        while(!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // swap
        var tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    // O(1)
    public int pop() {
        if(q1.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return q1.remove();
    }

    // O(1)
    public int top() {
        if(q1.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return q1.peek();
    }

    //O(1)
    public boolean empty() {
        return q1.isEmpty();
    }

}
