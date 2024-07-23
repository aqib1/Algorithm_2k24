package org.algorithms.io.list;

class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}
public class FIFOUsingLinkedList {
    private Node first;

    public void push(int value) {
        var node = new Node(value);
        node.next = first;
        first = node;

    }

    public int pop() {
        Node previous = null, current = first;
        while(current.next != null) {
            previous = current;
            current = current.next;
        }
        int pop = current.value;
        if(previous != null) {
            previous.next = null;
        } else first = null;
        return pop;
    }

    public int peek() {
        return first.value;
    }


    public static void main(String[] args) {
        var stack = new FIFOUsingLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
